package com.yoyohr.client.resource.saiku.query;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Summary
 *
 * @author Leo <jiangwenhua@yoyohr.com>
 */
public class QueryModel {

    private Map<Object, Object> axes = new HashMap<>();
    private boolean visualTotals = false;
    private String visualTotalsPattern;
    private boolean lowestLevelsOnly = false;
    private Object details;
    private List<Object> calculatedMeasures = new ArrayList<>();
    private List<Object> calculatedMembers = new ArrayList<>();

    public Map<Object, Object> getAxes() {
        return axes;
    }

    public void setAxes(Map<Object, Object> axes) {
        this.axes = axes;
    }

    public boolean isVisualTotals() {
        return visualTotals;
    }

    public void setVisualTotals(boolean visualTotals) {
        this.visualTotals = visualTotals;
    }

    public String getVisualTotalsPattern() {
        return visualTotalsPattern;
    }

    public void setVisualTotalsPattern(String visualTotalsPattern) {
        this.visualTotalsPattern = visualTotalsPattern;
    }

    public boolean isLowestLevelsOnly() {
        return lowestLevelsOnly;
    }

    public void setLowestLevelsOnly(boolean lowestLevelsOnly) {
        this.lowestLevelsOnly = lowestLevelsOnly;
    }

    public Object getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public List<Object> getCalculatedMeasures() {
        return calculatedMeasures;
    }

    public void setCalculatedMeasures(List<Object> calculatedMeasures) {
        this.calculatedMeasures = calculatedMeasures;
    }

    public List<Object> getCalculatedMembers() {
        return calculatedMembers;
    }

    public void setCalculatedMembers(List<Object> calculatedMembers) {
        this.calculatedMembers = calculatedMembers;
    }
}
