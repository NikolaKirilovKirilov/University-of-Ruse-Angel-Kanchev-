
#include <iostream>
#include <iomanip>
#include <list>
#include <math.h>

using namespace std;

struct Point {
private:
	float x, y;

public:

	Point()
	{
		this->x = 0;
		this->y = 0;
	}
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
	Vector()
	{
		this->start = Point(0, 0);
		this->end = Point(1, 1);
	};
	Vector(float x1, float y1, float x2, float y2) {
		this->start = Point(x1, y1);
		this->end = Point(x2, y2);
	}
	Vector(Point start, Point end)
	{
		this->start = start;
		this->end = end;
	}
	Vector(Vector vec1, Vector vec2)
	{
		this->start = vec1.calculateMidCords();
		this->end = vec2.calculateMidCords();
	}

	Point getStart()
	{
		return this->start;
	}

	Point getEnd()
	{
		return this->end;
	}

	Point calculateMidCords()
	{
		Point midPoint = Point(
			((this->start.getX() + this->end.getX()) / 2),
			((this->start.getY() + this->end.getY()) / 2)
		);
		return midPoint;
	}
	float length()
	{
		float length = 0;

		return length = sqrt(
			((end.getX() - start.getX()) * (end.getX() - start.getX()))
			+
			((end.getY() - start.getY()) * (end.getY() - start.getY())));
	}
};

list<Point> enterPoints(int count)
{
	list<Point> points;

	for (int i = 0; i < count; i++)
	{
		float x, y;
		cin >> x >> y;

		Point point = Point(x, y);
		points.push_back(point);
	}

	return points;
}

list<Vector> addVectors(list<Point> points)
{
	list<Vector> vectors; int pointSize = points.size();
	Vector connector = Vector(points.back(), points.front());

	for (int i = 0; i < pointSize - 1; i++)
	{
		Point firstPoint = points.front();
		points.pop_front();

		Vector vector = Vector(
			firstPoint.getX(), firstPoint.getY(),
			points.front().getX(), points.front().getY());

		vectors.push_back(vector);
	}

	vectors.push_back(connector);
	return vectors;
}

list<Vector> findMidVectors(list<Vector> vectors)
{
	list<Vector> midVectors; int vectorsSize = vectors.size();
	Vector connector = Vector(vectors.back().calculateMidCords(), vectors.front().calculateMidCords());

	for (int i = 0; i < vectorsSize - 1; i++)
	{
		Point start = vectors.front().calculateMidCords();
		vectors.pop_front();
		Point end = vectors.front().calculateMidCords();

		midVectors.push_back(Vector(start, end));
	}

	midVectors.push_back(connector);
	return midVectors;
}

float calculateLengthOfNth(list<Vector> midVectors, int row)
{
	float length = 0;

	if (row > 1)
	{
		list<Vector> innerVectors;
		int midVecSize = midVectors.size();

		Vector connector = Vector(midVectors.back(), midVectors.front());

		for (int i = 0; i < midVecSize - 1; i++)
		{
			Vector Vec1 = midVectors.front();
			midVectors.pop_front();
			Vector Vec2 = Vector(Vec1, midVectors.front());
			innerVectors.push_back(Vec2);
		}

		innerVectors.push_back(connector);

		length += calculateLengthOfNth(innerVectors, row - 1);
	}
	else
	{
		{
			int midVecSize = midVectors.size();
			for (int i = 0; i < midVecSize; i++)
			{
				length += midVectors.front().length();
				midVectors.pop_front();
			}
		}
	}

	return length;
}

int main()
{
	int pointsCount;
	cin >> pointsCount;

	list<Point> points = enterPoints(pointsCount);
	list<Vector> vectors = addVectors(points);
	list<Vector> midVectors = findMidVectors(vectors);

	int row;
	cin >> row;

	float length = calculateLengthOfNth(vectors, row);
	if (row == 0) length = calculateLengthOfNth(vectors, row);
	else length = calculateLengthOfNth(midVectors, row);

	cout << fixed << setprecision(10) << length << endl;
}