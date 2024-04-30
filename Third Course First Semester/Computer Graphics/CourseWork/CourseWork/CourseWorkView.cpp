
// CourseWorkView.cpp : implementation of the CCourseWorkView class
//

#include "pch.h"
#include "framework.h"
// SHARED_HANDLERS can be defined in an ATL project implementing preview, thumbnail
// and search filter handlers and allows sharing of document code with that project.
#ifndef SHARED_HANDLERS
#include "CourseWork.h"
#endif

#include "CourseWorkDoc.h"
#include "CourseWorkView.h"

#ifdef _DEBUG
#define new DEBUG_NEW
#endif


// CCourseWorkView

IMPLEMENT_DYNCREATE(CCourseWorkView, CView)

BEGIN_MESSAGE_MAP(CCourseWorkView, CView)
	// Standard printing commands
	ON_COMMAND(ID_FILE_PRINT, &CView::OnFilePrint)
	ON_COMMAND(ID_FILE_PRINT_DIRECT, &CView::OnFilePrint)
	ON_COMMAND(ID_FILE_PRINT_PREVIEW, &CCourseWorkView::OnFilePrintPreview)
	ON_WM_CONTEXTMENU()
	ON_WM_RBUTTONUP()
END_MESSAGE_MAP()

// CCourseWorkView construction/destruction

CCourseWorkView::CCourseWorkView() noexcept
{
	// TODO: add construction code here

}

CCourseWorkView::~CCourseWorkView()
{
}

BOOL CCourseWorkView::PreCreateWindow(CREATESTRUCT& cs)
{
	// TODO: Modify the Window class or styles here by modifying
	//  the CREATESTRUCT cs

	return CView::PreCreateWindow(cs);
}

// CCourseWorkView drawing

void CCourseWorkView::OnDraw(CDC* /*pDC*/)
{
	CCourseWorkDoc* pDoc = GetDocument();
	ASSERT_VALID(pDoc);
	if (!pDoc)
		return;

	// TODO: add draw code for native data here
}


// CCourseWorkView printing


void CCourseWorkView::OnFilePrintPreview()
{
#ifndef SHARED_HANDLERS
	AFXPrintPreview(this);
#endif
}

BOOL CCourseWorkView::OnPreparePrinting(CPrintInfo* pInfo)
{
	// default preparation
	return DoPreparePrinting(pInfo);
}

void CCourseWorkView::OnBeginPrinting(CDC* /*pDC*/, CPrintInfo* /*pInfo*/)
{
	// TODO: add extra initialization before printing
}

void CCourseWorkView::OnEndPrinting(CDC* /*pDC*/, CPrintInfo* /*pInfo*/)
{
	// TODO: add cleanup after printing
}

void CCourseWorkView::OnRButtonUp(UINT /* nFlags */, CPoint point)
{
	ClientToScreen(&point);
	OnContextMenu(this, point);
}

void CCourseWorkView::OnContextMenu(CWnd* /* pWnd */, CPoint point)
{
#ifndef SHARED_HANDLERS
	theApp.GetContextMenuManager()->ShowPopupMenu(IDR_POPUP_EDIT, point.x, point.y, this, TRUE);
#endif
}


// CCourseWorkView diagnostics

#ifdef _DEBUG
void CCourseWorkView::AssertValid() const
{
	CView::AssertValid();
}

void CCourseWorkView::Dump(CDumpContext& dc) const
{
	CView::Dump(dc);
}

CCourseWorkDoc* CCourseWorkView::GetDocument() const // non-debug version is inline
{
	ASSERT(m_pDocument->IsKindOf(RUNTIME_CLASS(CCourseWorkDoc)));
	return (CCourseWorkDoc*)m_pDocument;
}
#endif //_DEBUG


// CCourseWorkView message handlers
