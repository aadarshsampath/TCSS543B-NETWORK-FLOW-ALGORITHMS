package graphs1;
import java.util.Iterator;
import java.util.LinkedList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

public class FordFulkerson {
    Double maxflow=new Double(0);
    Double bottleneck;
    Object min_path;
    SimpleGraph G;
    int indexofstart=-1;
    int indexofsink=-1;
    public double Ford_Fulkerson(SimpleGraph g)
    {
        G=g;
        boolean check=false;
        findvertex("t");
        //findvertex("s");
        while(true)
        {
            check=findPath();
            if(check==false)
            {
                break;
            }
            bottleneck=update();
            maxflow=maxflow+bottleneck; //set bottleneck in find path           
        }
        return maxflow;
    }
    
    public boolean findPath()
    {
        Iterator<Vertex> i;
        Vertex temp;
        boolean[] marked =new boolean[G.numVertices()];
        for(int j=0; j<G.numVertices();j++)
        {
            marked[j]=false;
        }
        marked[0]=true;
        if(!DFS(G.vertexList.getFirst(),marked))
        {
            return false;
        }
        return true;
    }
    public double update()
    {
        int tempedge;
        Edge updateedge;
        Vertex p=G.vertexList.get(indexofsink);
        Double min=Double.MAX_VALUE;
        while(p!=null)
        {
            Object parent=p.getData();
            Vertex temp2=(Vertex)parent;          
            if(temp2!=null)
            {
                int ind=G.vertexList.indexOf(temp2);
                tempedge=findedge(temp2,p);
                updateedge=G.edgeList.get(tempedge);     
                min=Math.min((double)min,(double)updateedge.getData());              
            }
            p=temp2;
        }
        p=G.vertexList.get(indexofsink);
        while(p!=null)
        {
            Object parent=p.getData();
            Vertex temp2=(Vertex)parent;           
            if(temp2!=null)
            {
                int ind=G.vertexList.indexOf(temp2);
                tempedge=findedge(temp2,p);
                updateedge=G.edgeList.get(tempedge);     
                updateedge.setData((Double)updateedge.getData()-min);
                tempedge=findedge(p,temp2);
                updateedge=G.edgeList.get(tempedge);     
                updateedge.setData((Double)updateedge.getData()+min);              
            }
            p=temp2;
        }
           return min;     
    }
    public int findedge(Vertex st, Vertex en)
    {
        Iterator<Edge> j;
        Edge e;
         for (j = G.incidentEdges(st); j.hasNext();) {
                e =  j.next();
                if(e.getSecondEndpoint()==en)
                {
                    return G.edgeList.indexOf(e);
                }
         }
         return -1;
    }
    public void findvertex(String data)
    {
        Iterator<Vertex> i;
        int k=0;
        Vertex temp;
         for (i= G.vertices(); i.hasNext();k++ ) {
            temp =  i.next();  
            if(temp.getName().toString().equals(data))
            {
                if(data.equals("t"))
                {indexofsink=k;
                break;
                }
                else
                {
                    indexofstart=k;
                    break;
                }
            }
        }           
    }
    
    public boolean DFS(Vertex node, boolean []m )
    {
        Iterator<Edge> j;
        Edge e;
        Vertex v;
        if(m[indexofsink])
        {
            return true;
        }
        for (j = G.incidentEdges(node); j.hasNext();) {
                e =  j.next();
                v=e.getSecondEndpoint();
                int ind=G.vertexList.indexOf(v);
                if(m[ind]==false & (Double)e.getData()>0)
                {
                    m[ind]=true;
                    v.setData(e.getFirstEndpoint());
                    if(DFS(v,m))
                    {
                        return true;
                    }
                }
        }
        return false;
    }
    
}




