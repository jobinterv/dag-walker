CODING EXERCISE

Directed acyclic graphs (DAGs) are a class of graph in computer science. “Directed” meaning the structure goes one way (there are from and to vertices, conceptually); “acyclic” meaning there are no loops (if A leads to B, B cannot lead to A).
DAGs are a collection of vertices and edges, which could be represented as simple objects (these classes are just to illustrate, you can use them or define your own):

class Vertex {
    long id
}

class Edge {
    Vertex from
    Vertex to
}

Given a DAG and a vertex, calculate the longest directed path from that vertex. 
