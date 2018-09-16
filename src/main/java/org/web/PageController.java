package org.web;

public class PageController {
    public int getMaxPage(int curPage){
        int maxPage = 0;
        if(curPage%10 != 0) {
            maxPage = ((curPage / 10) + 1) * 10;
        }else {
            maxPage = ((curPage / 10)  ) * 10;
        }
        return maxPage;
    }


}
