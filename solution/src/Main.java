import java.util.List;



public class Main {
    public static void main(String[] args) {
        setUpGraph();
        testCase1();
        testCase2();
        testCase3();
        testCase4();
        testCase5();
        testCase6();
        testCase7();
        testCase8();
    }

    private static DirectedAcyclicGraph graph = new DirectedAcyclicGraph();


    private static void setUpGraph(){
        graph.addOrUpdateVertex(Vertex.instance(1L, new Long[]{3L, 4L}));
        graph.addOrUpdateVertex(Vertex.instance(2L, new Long[]{5L, 6L, 7L}));
        graph.addOrUpdateVertex(Vertex.instance(3L, new Long[]{4L, 5L}));
        graph.addOrUpdateVertex(Vertex.instance(4L, new Long[]{5L, 7L}));
        graph.addOrUpdateVertex(Vertex.instance(5L, new Long[]{7L, 8L}));
        graph.addOrUpdateVertex(Vertex.instance(6L, new Long[]{9L, 10L}));
        graph.addOrUpdateVertex(Vertex.instance(7L, new Long[]{10L, 11L}));
        graph.addOrUpdateVertex(Vertex.instance(8L, new Long[]{9L, 12L, 15L}));

        graph.addOrUpdateVertex(Vertex.instance(9L, new Long[]{10L, 11L}));
        graph.addOrUpdateVertex(Vertex.instance(10L, new Long[]{11L, 12L, 14L, 30L}));
        graph.addOrUpdateVertex(Vertex.instance(11L, new Long[]{16L}));
        graph.addOrUpdateVertex(Vertex.instance(12L, new Long[]{}));
        graph.addOrUpdateVertex(Vertex.instance(13L, new Long[]{14L}));
        graph.addOrUpdateVertex(Vertex.instance(14L, new Long[]{16L, 17L, 18L}));
        graph.addOrUpdateVertex(Vertex.instance(15L, new Long[]{19L, 20L}));
        graph.addOrUpdateVertex(Vertex.instance(16L, new Long[]{}));
        graph.addOrUpdateVertex(Vertex.instance(17L, new Long[]{}));
        graph.addOrUpdateVertex(Vertex.instance(18L, new Long[]{}));
        graph.addOrUpdateVertex(Vertex.instance(19L, new Long[]{}));
        graph.addOrUpdateVertex(Vertex.instance(20L, new Long[]{}));
    }

    private static void explorePath(long start){
        List<List<Long>> paths = graph.getAllPaths(start);
        int max = 0;
        for(List<Long> path : paths){
            System.out.println(path);
            if(path.size() > max)
                max = path.size();
        }

        System.out.println("longest path: " + max);
    }

    private static void testCase1(){
        System.out.println("TEST CASE 1:");
        explorePath(1L);

    }

    private static void testCase2(){
        System.out.println("TEST CASE 2:");
        explorePath(3L);
    }

    private static void testCase3(){
        System.out.println("TEST CASE 3:");
        explorePath(5L);
    }

    private static void testCase4(){
        System.out.println("TEST CASE 4:");
        explorePath(9L);
    }


    private static void testCase5(){
        System.out.println("TEST CASE 5:");
        explorePath(11L);
    }

    private static void testCase6(){
        System.out.println("TEST CASE 6:");
        explorePath(13L);
    }

    private static void testCase7(){
        System.out.println("TEST CASE 7:");
        explorePath(30L);
    }

    private static void testCase8(){
        System.out.println("TEST CASE 8:");
        System.out.println("Data validation -- newly added vertex introducing cycling data pattern");

        try {
            graph.addOrUpdateVertex(Vertex.instance(16L, new Long[]{8L}));
        }catch(Exception e){
            e.printStackTrace();
        }
    }


}