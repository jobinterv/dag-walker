import java.util.*;

/*
DirectedAcyclicGraph class allows vertex data to be added or replaced in any order.
Exception will be thrown if added or replaced vertex introduces cyclic pattern in the graph.
Given a vertex id, all the possible paths can be retrieved from the graph.
 */
public class DirectedAcyclicGraph {
    private HashMap<Long, Vertex> vmap;

    public DirectedAcyclicGraph() {
        this.vmap = new HashMap<>();
    }

    public void addOrUpdateVertex(Vertex vertex){
        if(vertex==null)
            throw new IllegalArgumentException("vertex cannot be null");

        Long vid = vertex.getId();
        vmap.put(vid, vertex);

        if(checkCyclicPattern(vid)){
            vmap.remove(vid);
            throw new IllegalArgumentException("Cyclic pattern detected; Specified vertex cannot be added i.e. " + vertex);
        }

    }

    private boolean checkCyclicPattern(Long start){

        List<List<Long>> paths = getAllPaths(start);
        for(List<Long> path : paths){
            if(checkRepeated(path))
                return true;
        }

        return false;
    }

    public Vertex getVertex(Long id){
        return vmap.get(id);
    }

    public List<List<Long>> getAllPaths(Long id){
        List<Long> path = new ArrayList<>();
        List<List<Long>> allPaths = new ArrayList<>();
        buildPaths(id, path, allPaths);

        return allPaths;
    }

    private boolean checkRepeated(List<Long> path){
        if(path == null)
            return false;

        Set<Long> idSet = new HashSet<>();
        for(Long id : path){
            if(idSet.contains(id))
                return true;

            idSet.add(id);
        }

        return false;
    }

    private void buildPaths(Long id, List<Long> path, List<List<Long>> allPaths){
        List<Long> newPath = new ArrayList<>();
        newPath.addAll(path);

        Vertex v = vmap.get(id);
        if(v == null){
            allPaths.add(path);
            return;
        }

        newPath.add(id);
        //if id is being repeated, force the stop condition.
        //Otherwise, infinite looping will arise during the path building
        if(checkRepeated(newPath)){
            allPaths.add(newPath);
            return;
        }


        List<Long> nextIds = v.getNextIds();
        if(nextIds.size() == 0){
            allPaths.add(newPath);
            return;
        }

        for(Long nextId : nextIds){
            buildPaths(nextId, newPath, allPaths);
        }

    }


}
