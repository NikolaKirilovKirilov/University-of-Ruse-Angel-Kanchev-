#include <iostream>
#include <string>

using namespace std;

class CPublication
{
protected:
    string author;
    string title;
    int year;
public:
    CPublication() 
    {
        this->author = "No One";
        this->title = "No Title";
        this->year = 0;
    }
    CPublication(string author, string title, int year = 2000)
    {
        this->author = author;
        this->title = title;
        this->year = year;
    }
    virtual void getData()
    {
        cin >> this->author;
        cin >> this->title;
        cin >> this->year;
    }
    virtual void display() 
    {
        cout << this->author << endl;
        cout << this->title << endl;
        cout << this->year << endl;
    }
};

class CArticle : public CPublication
{
protected:
    string magazine;
    int issue;
    int startPage;
    int endPage;
public:
    CArticle()
        : CPublication()
    {
        this->magazine = "No magazine";
        this->issue = 0;
        this->startPage = 0;
        this->endPage = 0;
    }
    CArticle(string magazine ,int issue, int startPage, int endPage) 
        : CPublication()
    {
        this->magazine = magazine;
        this->issue = issue;
        this->startPage = startPage;
        this->endPage = endPage;
    }
    void getData() 
    {
        cin >> this->author;
        cin >> this->title;
        cin >> this->year;
        cin >> this->magazine;
        cin >> this->issue;
        cin >> this->startPage;
        cin >> this->endPage;
    }
    void display() 
    {
        cout << this->author << endl;
        cout << this->title << endl;
        cout << this->year << endl;
        cout << this->magazine << endl;
        cout << this->issue << endl;
        cout << this->startPage << endl;
        cout << this->endPage << endl;
    }
    int getNumberOfPages()
    {
        return this->endPage - this->startPage;
    }
};

int main()
{
    CPublication* articles[10];
    CPublication* under6[10]; int under6ctr = 0;
    int n; cin >> n;
    
    if (n < 10)
    {
        for (size_t i = 0; i < n; i++)
        {
            CArticle article;
            article.getData();

            articles[i] = &article;
            if (article.getNumberOfPages() < 6)
            {
                under6[under6ctr++] = &article;
            }
        }
    }
    else
    {
        return 0;
    }
    cout << endl;

    for (size_t i = 0; i < n; i++)
    {
        articles[i]->display();
        cout << endl;
    }

    cout << endl << "----- Under 6 pages -----" << endl;

    for (size_t i = 0; i < under6ctr; i++)
    {
        under6[i]->display();
        cout << endl;
    }
}
