package com.yoyohr.client.resource.saiku.query;

import java.util.List;

/**
 * Summary
 *
 * @author Leo <jiangwenhua@yoyohr.com>
 */
public class QueryResult {

    private List<Cell[]> cellset;
    private Object[][] rowTotalsLists;
    private Object[][] colTotalsLists;
    private Integer runtime;
    private String error;
    private Integer height;
    private Integer width;
    private Query query;
    private int topOffset;
    private int leftOffset;

    public QueryResult() {

    }

    public List<Cell[]> getCellset() {
        return cellset;
    }

    public void setCellset(List<Cell[]> cellset) {
        this.cellset = cellset;
    }

    public Object[][] getRowTotalsLists() {
        return rowTotalsLists;
    }

    public void setRowTotalsLists(Object[][] rowTotalsLists) {
        this.rowTotalsLists = rowTotalsLists;
    }

    public Object[][] getColTotalsLists() {
        return colTotalsLists;
    }

    public void setColTotalsLists(Object[][] colTotalsLists) {
        this.colTotalsLists = colTotalsLists;
    }

    public Integer getRuntime() {
        return runtime;
    }

    public void setRuntime(Integer runtime) {
        this.runtime = runtime;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Query getQuery() {
        return query;
    }

    public void setQuery(Query query) {
        this.query = query;
    }

    public int getTopOffset() {
        return topOffset;
    }

    public void setTopOffset(int topOffset) {
        this.topOffset = topOffset;
    }

    public int getLeftOffset() {
        return leftOffset;
    }

    public void setLeftOffset(int leftOffset) {
        this.leftOffset = leftOffset;
    }
}
