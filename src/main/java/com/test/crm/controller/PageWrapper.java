package com.test.crm.controller;

import org.springframework.data.domain.Page;

import java.util.ArrayList;
import java.util.List;

public class PageWrapper<T> {
    public static final int MAX_PAGE_ITEM_DISPLAY = 5;
    private Page<T> page;
    private List<PageItem> items;
    private int currentNumber;
    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public PageWrapper(Page<T> page, String url) {
        this.page = page;
        this.url = url;
        items = new ArrayList<PageItem>();

        currentNumber = page.getNumber() + 1;

        int start = 1;
        int size = MAX_PAGE_ITEM_DISPLAY;

        if (page.getTotalPages() <= MAX_PAGE_ITEM_DISPLAY) {
            size = page.getTotalPages();
        } else if (currentNumber >= page.getTotalPages() - MAX_PAGE_ITEM_DISPLAY / 2) {
            start = page.getTotalPages() - MAX_PAGE_ITEM_DISPLAY + 1;
        } else {
            start = currentNumber - MAX_PAGE_ITEM_DISPLAY / 2;
        }

        for (int i = 0; i < size; i++) {
            items.add(new PageItem(start + i, (start + i) == currentNumber));
        }
    }

    public List<PageItem> getItems() {
        return items;
    }

    public void setItems(List<PageItem> items) {
        this.items = items;
    }

    public int getNumber() {
        return currentNumber;
    }

    public List<T> getContent() {
        return page.getContent();
    }

    public int getSize() {
        return page.getSize();
    }

    public int getTotalPages() {
        return page.getTotalPages();
    }

    public long getTotalElements() {
        return page.getTotalElements();
    }

    public boolean isFirstPage() {
        return page.isFirst();
    }

    public boolean isLastPage() {
        return page.isLast();
    }

    public boolean isHasPreviousPage() {
        return page.hasPrevious();
    }

    public boolean isHasNextPage() {
        return page.hasNext();
    }

    public class PageItem {
        private int number;
        private boolean current;

        public PageItem(int number, boolean current) {
            this.number = number;
            this.current = current;
        }

        public int getNumber() {
            return this.number;
        }

        public boolean isCurrent() {
            return this.current;
        }
    }
}
