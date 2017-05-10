package org.zerock.domain;

import java.net.URLEncoder;

import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

public class PagerMaker {

	private int total,startPage,endPage;
	private boolean prev,next;
	private Criteria cri;
	
	private int displayPageNum=10;
	
	public PagerMaker(int total, Criteria cri) {
		this.total = total;
		this.cri = cri;
		calc();
	} 
	
	
	public int getStartPage() {
		return startPage;
	}


	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}


	public int getEndPage() {
		return endPage;
	}


	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}


	public boolean isPrev() {
		return prev;
	}


	public void setPrev(boolean prev) {
		this.prev = prev;
	}


	public boolean isNext() {
		return next;
	}


	public void setNext(boolean next) {
		this.next = next;
	}


	public Criteria getCri() {
		return cri;
	}


	public void setCri(Criteria cri) {
		this.cri = cri;
	}


	public int getTotal() {
		return total;
	}


	public void setTotal(int total) {
		this.total = total;
	}


	public int getDisplayPageNum() {
		return displayPageNum;
	}


	public void setDisplayPageNum(int displayPageNum) {
		this.displayPageNum = displayPageNum;
	}


	public void calc(){
		
		int tempEnd= (int)(Math.ceil(cri.getPage()/(double)cri.getPageNum())*displayPageNum);
		startPage=tempEnd-9;
		endPage = tempEnd*cri.getPageNum()>total? (int)(Math.ceil(total/(double)cri.getPageNum())):tempEnd;
		
		prev = startPage==1? false:true;
		next = endPage*cri.getPageNum()<total? true:false;
		
	}

	public String makeSearch(int page){
		
		UriComponents uriComponents=
				UriComponentsBuilder.newInstance()
				.queryParam("page", page)
				.queryParam("pageNum",cri.getPageNum())
				.queryParam("searchType", ((SearchCriteria)cri).getSearchType())
				.queryParam("keyword",encoding(((SearchCriteria) cri).getKeyword())).build();
		
		return uriComponents.toUriString();
	}
	
	
	
	
	private String encoding(String keyword) {
		
		if(keyword==null||keyword.trim().length()==0){
			return "";
		}
		try{
			return URLEncoder.encode(keyword,"UTF-8");
		}catch (Exception e) {
			return "";
		}
		
		
	}


	public String makeQuery(int page){
		UriComponents uriComponents=
				UriComponentsBuilder.newInstance()
				.queryParam("page", page)
				.queryParam("pageNum",cri.getPageNum()).build();
		
		return uriComponents.toUriString();
	}
	
	
	@Override
	public String toString() {
		return "PagerMaker [total=" + total + ", startPage=" + startPage + ", endPage=" + endPage + ", prev=" + prev
				+ ", next=" + next + ", cri=" + cri + ", displayPageNum=" + displayPageNum + "]";
	}
	
	
	
	
	
	
	
}
