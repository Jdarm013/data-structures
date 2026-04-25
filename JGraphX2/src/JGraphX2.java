import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.SwingConstants;

import com.mxgraph.layout.mxCompactTreeLayout;
import com.mxgraph.layout.hierarchical.mxHierarchicalLayout;
import com.mxgraph.model.mxGeometry;
import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.util.mxConstants;
import com.mxgraph.util.mxPoint;
import com.mxgraph.util.mxRectangle;
import com.mxgraph.view.mxGraph;

public class JGraphX2 extends JFrame
{
    private static final long serialVersionUID = -2707712944901661771L;
    SimpleTreeNode<SpaceNode> root = SimpleTreeNode.buildSolarSystem();

    public void fillGraphFromModel(mxGraph graph) {
        Object parent = graph.getDefaultParent();
        graph.getModel().beginUpdate();

        try
        {
            graph.getView().setTranslate(new mxPoint(50, 50));

            Object vRoot = graph.insertVertex(parent, null,
                    root.getData(), 80, 0, 120, 60,
                    getStyleForType(root.getData().getType()));

            CreateGraphPoints(graph, parent, vRoot, root);

            mxHierarchicalLayout layout = new mxHierarchicalLayout(graph);
            layout.setUseBoundingBox(false);
            layout.execute(parent);
        }
        finally
        {
            graph.getModel().endUpdate();
        }

        mxGraphComponent graphComponent = new mxGraphComponent(graph);
    }

    public void CreateGraphPoints(mxGraph graph, Object parent, Object vRoot, SimpleTreeNode<SpaceNode> parentNode)
    {
        for (SimpleTreeNode child : parentNode.getChildren())
        {
            SpaceNode data = (SpaceNode) child.getData();
            Object meRoot = graph.insertVertex(parent, null,
                    data, 80, 0, 120, 60,
                    getStyleForType(data.getType()));
            graph.insertEdge(parent, null, "", vRoot, meRoot);

            if (child.childCount() > 0)
            {
                CreateGraphPoints(graph, parent, meRoot, child);
            }
        }
    }

    private String getStyleForType(String type) {
        return switch (type.toLowerCase()) {
            case "system" -> "rounded=true;fillColor=#2c2c54;fontColor=white;strokeColor=#706fd3;fontSize=11;";
            case "star" -> "rounded=true;fillColor=#f9ca24;fontColor=black;strokeColor=#f0932b;fontSize=11;";
            case "group" -> "rounded=true;fillColor=#535c68;fontColor=white;strokeColor=#a4b0be;fontSize=11;";
            case "planet" -> "rounded=true;fillColor=#0652DD;fontColor=white;strokeColor=#1289A7;fontSize=11;";
            case "dwarf planet" -> "rounded=true;fillColor=#6F1E51;fontColor=white;strokeColor=#B53471;fontSize=11;";
            case "moon" -> "rounded=true;fillColor=#808e9b;fontColor=white;strokeColor=#d2dae2;fontSize=11;";
            default -> "rounded=true;fillColor=white;fontColor=black;fontSize=11;";
        };
    }

    public JGraphX2()
    {
        super("Solar System Hierarchy");
        mxGraph graph = new mxGraph();
        fillGraphFromModel(graph);
        mxGraphComponent graphComponent = new mxGraphComponent(graph);
        getContentPane().add(graphComponent);
    }

    public static void main(String[] args)
    {
        JGraphX2 frame = new JGraphX2();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1700, 900);
        frame.setVisible(true);
    }
}