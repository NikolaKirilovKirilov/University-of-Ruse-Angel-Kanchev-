
#include <iostream>
#include <list>
#include <math.h>

using namespace std;

struct Point {
private:
	float x, y;

public:

	Point() {};
	Point(float x, float y) {
		this->x = x;
		this->y = y;
	}

	float getX()
	{
		return x;
	}
	float getY()
	{
		return y;
	}
};

struct Vector {
private:
	Point start;
	Point end;

public:
	Vector() {};
	Vector(float x1, float y1, float x2, float y2) {
		this->start = Point(x1, y1);
		this->end = Point(x2, y2);
	}

	Point calculateMidCords()
	{
		Point midPoint = Point(
			((this->start.getX() + this->end.getX()) / 2),
			((this->start.getY() + this->end.getY()) / 2)
		);
		return midPoint;
	}
};

class MidVector : public Vector {
private:
	Vector vec1;
	Vector vec2;

public:
	MidVector() {};
	MidVector(Vector vec1, Vector vec2)
	{
		this->vec1 = vec1;
		this->vec2 = vec2;
	}

	float length()
	{
		float length = 0;
		Point vec1MidPoint = this->vec1.calculateMidCords();
		Point vec2MidPoint = this->vec2.calculateMidCords();

		return length = sqrt(
			pow(vec2MidPoint.getX() - vec1MidPoint.getX(), 2)
			+
			pow(vec2MidPoint.getY() - vec1MidPoint.getY(), 2)
		);
	}
};

int main()
{
	int pointsCount;
	cin >> pointsCount;

	list<Point> points;

	for (int i = 0; i < pointsCount; i++)
	{
		float x, y;
		cin >> x >> y;

		Point point = Point(x, y);
		points.push_back(point);
	}

	list<Vector> vectors;
	int pointsSize = points.size();

	for (int i = 0; i < pointsSize - 1; i++)
	{
		Point firstPoint = points.front();
		points.pop_front();

		Vector vector = Vector(
			firstPoint.getX(), firstPoint.getY(),
			points.front().getX(), points.front().getY());

		vectors.push_back(vector);
	}

	list<MidVector> midVectors;
	int vectorsSize = vectors.size();

	for (int i = 0; i < vectorsSize - 1; i++)
	{
		Vector firstVector = vectors.front();
		vectors.pop_front();

		MidVector midVector = MidVector(firstVector, vectors.front());

		midVectors.push_back(midVector);
	}

	float length = 0;
	for (int i = 0; i < midVectors.size(); i++)
	{
		length += midVectors.front().length();
	}

	int number; cin >> number;
	cout << length;
}