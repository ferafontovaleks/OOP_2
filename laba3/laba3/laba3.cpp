#include <windows.h>
#include <gl/GL.h>
#include <gl/glut.h>
#include <iostream>
#include <fstream>
#include <vector>
#include <cmath>
#include <string>
using namespace std;

class Point {
private:
	double pX, pY;
public:
	Point(double x, double y) {
		pX = x;
		pY = y;
	}

	double getX() { return pX; }

	double getY() { return pY; }

	Point operator-(Point& temp) { return Point(pX - temp.pX, pY - temp.pY); }
};

int const h = 550, w = 550, pointSize = 5;
double const xmax = 10, xmin = -1, ymax = 10, ymin = -1, eps = 0.5;
double fX, fY;
bool mouseInput, locatePoint = false;
int var;
vector<Point> point;
string file, line;

//Вычисляем расстояние между двумя точками
double distance(Point p1, Point p2) {
	Point temp = p2 - p1;
	return sqrt(temp.getX() * temp.getX() + temp.getY() * temp.getY());
}

void drawBack() {
	glColor3f(0.0, 0.0, 1.0);
	glClear(GL_COLOR_BUFFER_BIT);
	glFinish();
}

void drawVector(Point p1, Point p2) {
	glBegin(GL_LINES);
	glVertex3f(p1.getX(), p1.getY(), 0);
	glVertex3f(p2.getX(), p2.getY(), 0);
	glEnd();
	glFlush();
}

void drawPoint(Point p) {
	glBegin(GL_POINTS);
	glVertex3f(p.getX(), p.getY(), 0);
	glEnd();
	glFlush();
}
//Вычисляем ориентацию точки
double findOrientation(Point p, Point v1, Point v2) {
	return (p.getX() - v1.getX()) / (v2.getX() - v1.getX()) - (p.getY() - v1.getY()) / (v2.getY() - v1.getY());
}

void checkLocation(Point p) {
	int intersections = 0; //Инициализ счетчик пересеч луча.
	for (int i = 0; i < point.size(); i++) { //проходим по всем ребрам многоуг
		int next = (i + 1) % point.size(); //Получаем индекс след вершины
		//Если т. `p` не наход в области, огранич по `y` тек ребром, то пересеч нет
		if (p.getY() < min(point[i].getY(), point[next].getY()) || p.getY() > max(point[i].getY(), point[next].getY())){
			intersections += 0;
		}
		else
			if (max(point[i].getY(), point[next].getY()) == p.getY()) { //Если т. лежит на ребре по `y`, то:
				Point p1(0, 0); //Создаем временную точку
				//Если `y`  ребра соответствует `y`  т. `points[i]`, то `p1`  присв коорд `points[i]`
				if (max(point[i].getY(), point[next].getY()) == point[i].getY()) Point p1(point[i].getX(), point[i].getY());
				//Иначе `p1`  присв коорд `points[next]`.
				else Point p1(point[next].getX(), point[next].getY());
				//Если `x` т. `p` меньше `x` т. `p1`, то пересеч считается.
				if (p.getX() < p1.getX()) intersections++;
			}
			else {//Если т. `p` не лежит на ребре по `y`, то:
				//Если т. `p` лежит на ребре, то пересеч есть, и цикл прерывается.
				if (!findOrientation(p, point[i], point[next])) { 
					intersections = 1; break; 
				} 
				//Если т. `p` лежит по разные стороны от тек ребра и горизонт линии, проход через `p`, то пересеч считается.
				else if ((findOrientation(p, point[i], point[next]) * findOrientation(Point(xmax, p.getY()), point[i], point[next]) < 0)) {
					intersections++;
				}
			}
	}
	//отрисовка т.
	glBegin(GL_POINTS);
	glVertex3f(p.getX(), p.getY(), 0);
	glColor3f(1.0 * (1 - (intersections % 2)), 1.0 * (intersections % 2), 0.0);
	glEnd();
	glFlush();

}

void addPoint(Point p) {
	if (!locatePoint) {
		point.push_back(p);
		if (point.size() > 1) {
			for (int i = 1; i < point.size() - 1; i++) {
				if (distance(point[i], p) < eps) {
					point.pop_back();
					return;
				}
			}

			if (distance(point[0], p) < eps) {
				drawVector(point[point.size() - 2], point[0]);
				locatePoint = true;
				return;
			}
			drawVector(point[point.size() - 2], point[point.size() - 1]);
		}
	}
	else checkLocation(p);

	drawPoint(p);
}
void fileInput() {
	ifstream fin(file);
	string number;

	if (fin.is_open()) {
		while (getline(fin, line)) {
			number = "";
			for (int i = 0; i < line.length(); i++) {
				if (line[i] != ' ')
					number += line[i];
				else {
					fX = stod(number);
					number = "";
				}
			}
			fY = stod(number);
			addPoint(Point(fX, fY));
		}
	}
	else
		cout << "Файл не найден" << endl;
}

void inputPoints() {
	do {
		cout << "Выбирите метод ввода точек:" << endl;
		cout << "1. С помощью мыши" << endl;
		cout << "2. Выход" << endl;
		cout << "3. С файла" << endl;
		cin >> var;
	} while (var != 1 && var != 2 && var != 3);
	switch (var) {
	case 1: {mouseInput = true; break; }
	case 2: {exit(0); break; }
	case 3: {mouseInput = false;
		cout << "Введите имя файла(с указанием формата): " << endl;
		cin >> file;
		fileInput();
		break; }
	}
}

Point convert(int x, int y) {
	double scaleX = (xmax - xmin) / w, scaleY = (ymax - ymin) / h;
	return Point(x * scaleX + xmin, ymax - y * scaleY);
}

void display(void)
{
	drawBack();
	inputPoints();
}

void init(void)
{
	glClearColor(255.0, 255.0, 255.0, 255.0);
	glMatrixMode(GL_PROJECTION);
	glLoadIdentity();
	glOrtho(xmin, xmax, ymin, ymax, -1.0, 1.0);
	glPointSize(pointSize);
	glEnable(GL_POINT_SMOOTH);
}

void mouse(int button, int state, int x, int y) {
	if ((button == GLUT_LEFT_BUTTON) && (state == GLUT_UP) && mouseInput) {
		addPoint(convert(x, y));
	}
	else if ((button == GLUT_RIGHT_BUTTON) && (state == GLUT_UP)) {
		glClear(GL_COLOR_BUFFER_BIT);
		glFlush();
		point.clear();
		locatePoint = false;
		drawBack();
		inputPoints();
	}
}

int main(int argc, char** argv)
{
	setlocale(LC_ALL, "Russian");
	glutInit(&argc, argv);
	glutInitDisplayMode(GLUT_SINGLE | GLUT_RGB);
	glutInitWindowSize(550, 550);
	glutInitWindowPosition(100, 100);
	glutCreateWindow("Polygons");
	init();
	glutDisplayFunc(display);
	glutMouseFunc(mouse);
	glutMainLoop();
	return 0;
}