# TCSS543B-NETWORK-FLOW-ALGORITHMS

Implemented Three Network Flow Algorithms and Analyzed Performance Varying the Input Parameters

SOFTWARE REQUIREMENTS : JAVA [JDK1.6 and above]
The given "graphs1" folder contains all the graph files, algorithms and the compiled ".class" files for each of the java files.

STEPS TO RUN CODE:
1) Go to the command line and navigate to the CODE DOCUMENTATION folder and execute the following command:
"java graphs1.tcss543 path\filename.txt"
where path should specify the path leading to the folder where we can find the input graphs and filename correspond to the input file you want to test.
2) Input text files were created from the generating the graph codes.
These files are present in a separate folder called OUTPUT which contains sub-folders corresponding to each graph type.

CODE DOCUMENTATION: 
FordFulkerson.java
1.	Function: public double Ford_Fulkerson(SimpleGraph g)
This function is the main ford Fulkerson algorithm that takes the input graph, finds augmenting paths and updates the graph accordingly. It returns the maxflow and calculates it by adding the bottleneck each time. 
2.	Function: public boolean findPath()
This function calls DFS to search for augmenting paths in the graph and if it finds a path it returns true else false. 
3.	Function: public double update()
This function finds the bottleneck in the path found, updates the graph and returns the bottleneck to be used for the calculation of the maxflow. 
4.	Function: public void findvertex(String data)
This function finds the index of any particular vertex in the graph by just traversing the vertex list. We use it for finding the index of the source and sink. 
5.	Function: public int findedge(Vertex st, Vertex en)
This function finds the index of the edge between the two input nodes. 
6.	Function: public boolean DFS(Vertex node, boolean []m )
DFS is the usual DFS algorithm function that tries to find a path between the source and sink and returns true if it finds one. 

ScalingFF.java
1.	Function: public double Scaling_Ford_Fulkerson(SimpleGraph g)
This is the main function of the scaling algorithm that calculates the delta and then finds augmenting paths using the delta, updates the graph and then calculates the maxflow. 
2.	Function: public double calculatedelta()
This function calculates delta by summing up all capacities of edges going out of source.
3.	Function: public boolean findPath()
This function calls DFS to search for augmenting paths in the graph and if it finds a path it returns true else false. 
4.	Function: public double update()
This function finds the bottleneck in the path found, updates the graph and returns the bottleneck to be used for the calculation of the maxflow. 
5.	Function: public void findvertex(String data)
This function finds the index of any particular vertex in the graph by just traversing the vertex list. We use it for finding the index of the source and sink. 
6.	Function: public int findedge(Vertex st, Vertex en)
This function finds the index of the edge between the two input nodes. 
7.	Function: public boolean DFS(Vertex node, boolean []m )
DFS is the usual DFS algorithm function that tries to find a path between the source and sink, the only difference here is that the capacity is checked against delta rather than zero. 

PreflowPush.java
1.	Function: public double Preflow(SimpleGraph g)
This function is the main function that runs the preflow push algorithm. It first initializes the flows, excess and heights. Then it checks if there is any node that has an excess and it is not the sink node, for every neighbor of that node through which excess can be pushed it pushes the overflow or else it relabels the node. 
2.	Function: public void Relabel(int ind)
This function relabels the height of the input node by incrementing it. 
3.	Function: public void Push(Double ex, Double cap, int ind1, int ind2, int ind3, int ind4)
This function implements push by finding the minimum out of the capacity of the edge and the excess on the node. Then it updates the flows and excess values. 
4.	Function: public void setflows()
This function sets the initial flows on all edges. 
5.	Function: public void setexcess()
This function sets the excess values of all nodes such that the source has negative excess, the nodes linked to the source have excess equivalent to the capacity of the edge between the source and that node and other nodes have zero excess initialy. 
6.	Function: public void findvertex(String data)
This function finds the index of any particular vertex in the graph by just traversing the vertex list. We use it for finding the index of the source and sink. 
7.	Function: public int findedge(Vertex st, Vertex en)
This function finds the index of the edge between the two input nodes. 



