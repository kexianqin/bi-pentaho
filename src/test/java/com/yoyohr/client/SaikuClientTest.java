package com.yoyohr.client;

import com.yoyohr.AbstractTest;
import com.yoyohr.client.resource.saiku.bean.*;
import com.yoyohr.client.resource.saiku.query.QueryResult;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Summary
 *
 * @author Leo <jiangwenhua@yoyohr.com>
 */
public class SaikuClientTest extends AbstractTest {

    SaikuClient client;

    String saikuCubeUniqueName = "[youpin_dwh].[youpin_dwh].[youpin_dwh].[youpin_dwh]";
    String mdx = "WITH\nSET [~ROWS] AS\n    {[operator].[operator].[operator_name].Members}\nSELECT\nNON EMPTY {[Measures].[action_key]} ON COLUMNS,\nNON EMPTY [~ROWS] ON ROWS\nFROM [youpin_dwh]";

    @Before
    public void setup() throws UnanthenticatedException, IOException, URISyntaxException {
        client = new SaikuClient();
    }

    @Test
    public void testNewSaikuClient() {
        assertThat(client)
            .isInstanceOf(SaikuClient.class);
    }

    @Test
    public void testGetRestSaikuSession() throws IOException {
        assertThat(client.getRestSaikuSession())
            .isInstanceOf(SaikuSession.class)
            .hasFieldOrPropertyWithValue("username", "pentaho");
    }

    @Test
    public void testGetRestOlapConnections() throws IOException {
        assertThat(client.getRestOlapConnections().get(0))
            .isInstanceOf(SaikuConnection.class);
    }

    @Test
    public void testRefreshRestOlapConnections() throws IOException {
        assertThat(client.refreshRestOlapConnections().get(0))
            .isInstanceOf(SaikuConnection.class);
    }

    @Test
    public void testGetRestOlapConnectionn() throws IOException {
        assertThat(client.getRestOlapConnection("youpin_dwh").get(0))
            .isInstanceOf(SaikuConnection.class);
    }

    @Test
    public void testRefreshRestOlapConnection() throws IOException {
        assertThat(client.refreshRestOlapConnection("youpin_dwh").get(0))
            .isInstanceOf(SaikuConnection.class);
    }

    @Test
    public void testGetRestSaikuCubeMetadata() throws IOException {
        assertThat(client.getRestSaikuCubeMetadata(saikuCubeUniqueName))
            .isInstanceOf(SaikuCubeMetadata.class);
    }

    @Test
    public void testGetRestSaikuDimension() throws IOException {
        String dimensionName = "date";
        assertThat(client.getRestSaikuDimension(saikuCubeUniqueName, dimensionName))
            .isInstanceOf(SaikuDimension.class);
    }

    @Test
    public void testGetRestSaikuDimensionHierarchies() throws IOException {
        String dimensionName = "date";
        assertThat(client.getRestSaikuDimensionHierarchies(saikuCubeUniqueName, dimensionName).get(0))
            .isInstanceOf(SaikuHierarchy.class);
    }

    @Test
    public void testGetRestSaikuDimensionHierarchy() throws IOException {
        String dimensionName = "date";
        String hierarchyName = "date";
        assertThat(client.getRestSaikuDimensionHierarchy(saikuCubeUniqueName, dimensionName, hierarchyName).get(0))
            .isInstanceOf(SaikuLevel.class);
    }

    @Test
    public void testGetRestSaikuDimensions() throws IOException {
        assertThat(client.getRestSaikuDimensions(saikuCubeUniqueName).get(0))
            .isInstanceOf(SaikuDimension.class);
    }

    @Test
    public void testGetRestSaikuLevelMembers() throws IOException {
        String dimensionName = "date";
        String hierarchyName = "date";
        String levelName = "date_full";
        assertThat(client.getRestSaikuLevelMembers(saikuCubeUniqueName, dimensionName, hierarchyName, levelName).get(0))
            .isInstanceOf(SimpleCubeElement.class);
    }

    @Test
    public void testGetRestSaikuRootMembers() throws IOException {
        String hierarchyName = "date";
        assertThat(client.getRestSaikuRootMembers(saikuCubeUniqueName, hierarchyName).get(0))
            .isInstanceOf(SaikuMember.class)
            .hasFieldOrPropertyWithValue("uniqueName", "[date].[date].[All dates]");
    }

    @Test
    public void testGetRestSaikuCubeHierarchies() throws IOException {
        assertThat(client.getRestSaikuCubeHierarchies(saikuCubeUniqueName).get(0))
            .isInstanceOf(SaikuHierarchy.class)
            .hasFieldOrPropertyWithValue("uniqueName", "[Measures]");
    }

    @Test
    public void testGetRestSaikuCubeMeasures() throws IOException {
        assertThat(client.getRestSaikuCubeMeasures(saikuCubeUniqueName).get(0))
            .isInstanceOf(SaikuMeasure.class);
    }

    @Test
    public void testGetRestSaikuMember() throws IOException {
        String memberName = "enterprise_key";
        assertThat(client.getRestSaikuMember(saikuCubeUniqueName, memberName))
            .isInstanceOf(SaikuMember.class);
    }

    @Test
    public void testGetRestSaikuMemberChildren() throws IOException {
        String memberName = "enterprise_key";
        assertThat(client.getRestSaikuMemberChildren(saikuCubeUniqueName, memberName))
            .hasSize(0);
    }

    @Test
    public void testExecuteSaikuQuery() throws IOException {
        assertThat(client.executeSaikuQuery(saikuCubeUniqueName, mdx))
            .isInstanceOf(QueryResult.class);
    }

    @After
    public void tearDown() throws Exception {
        client.close();
    }
}
