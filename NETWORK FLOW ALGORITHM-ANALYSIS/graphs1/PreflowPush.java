package graphs1;
import java.util.Iterator;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author anamzahid
 */
public class PreflowPush {
    double[] heights;
    double[] excess;
    int indexofstart=-1;
    int indexofsink=-1;
    Double maxflow=(double) 0;
    SimpleGraph G;
    public double Preflow(SimpleGraph g){
        G=g;
        Iterator<Vertex> i;
        Iterator <Vertex>j;
        Iterator<Edge>k;
        Iterator<Edge> l;
        Vertex v1,v2,v;
        Edge e1,e2;
        int index=0,index2=-10,count=0;
        boolean check=false;
        Double maxex=(double) -1;
        findvertex("t");
        findvertex("s");
        excess=new double[G.numVertices()];
        for(j= G.vertices(); j.hasNext(); ) 
        {
             v1= j.next();
             v1.setData((double) 0);
             excess[index]=0;
             index++;
        }
        index=0;
        v1=G.vertexList.getFirst();
        v1.setData((double) G.numVertices());
        setflows();
        setexcess();
        while(true)
        {
             for (i= G.vertices(); i.hasNext(); ) {
                 v=  i.next();  
                 if(excess[index]>0&&!(v.getName().equals("t")))
                 {
                     v1=v;
                     index2=index;
                     count++;
                     break;
                 }
                 index++;
             }
             index=0;
             if(count==0)
             {
                break;
             }
             count=0;
                        
              for (k = G.incidentEdges(v1); k.hasNext();) {
                          e1 =  k.next();
                          v2=e1.getSecondEndpoint();
                          if((Double)e1.getName()>0&&(Double)v1.getData()>(Double)v2.getData())
                          {
                              int index3=findedge(v2,v1);
                              Push(excess[index2],(Double)e1.getName(),G.edgeList.indexOf(e1),index3,index2,G.vertexList.indexOf(v2));
                              check=true;
                              break;
                              
                          }
              }
               if(check!=true)
                          {
                              Relabel(G.vertexList.indexOf(v1));
                             // break;
                          }
                          check=false;
                      }
                      
                                              
        
        for (l = G.incidentEdges(G.vertexList.get(indexofsink)); l.hasNext();) {
                e2 = l.next();
                maxflow=maxflow+(Double)e2.getName();
        }
        return maxflow;
    }
    public void Relabel(int ind)
    {
        Vertex v=G.vertexList.get(ind);
        v.setData((Double)v.getData()+1);
    }
    
    public void Push(Double ex, Double cap, int ind1, int ind2, int ind3, int ind4)
    {
        Double d=Math.min(ex, cap);
        Edge e1=G.edgeList.get(ind1);
        Edge e2=G.edgeList.get(ind2);
        e1.setName((Double)e1.getName()-d);
        e2.setName((Double)e2.getName()+d);
        excess[ind3]=excess[ind3]-d;
        excess[ind4]=excess[ind4]+d;
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
                else if(data.equals("s"))
                {
                    indexofstart=k;
                    break;
                }
            }
        }             
    }
    public void setflows()
    {
        Vertex start,end;
        Edge e,e2;
        Iterator<Vertex> i;
                Iterator<Edge> j;
                Iterator <Edge> k;
        double temp;
        int ind;
        for (i= G.vertices(); i.hasNext(); ) {
            start =  i.next();             
            for (j = G.incidentEdges(start); j.hasNext();) {
                e =  j.next();
                e.setName(e.getData());
        }
      }
        for (j = G.incidentEdges(G.vertexList.getFirst()); j.hasNext();) {
                e = j.next();
                temp=(Double)e.getName();
                e.setName((double) 0);
                end=e.getSecondEndpoint();
                ind=findedge(end, G.vertexList.getFirst());
                e2=G.edgeList.get(ind);
                e2.setName(temp);
        }
    }
    public void setexcess()
    {
        double temp=new Double(0);
        Iterator <Edge> j;
        Edge e;
        Vertex end;
        for (j = G.incidentEdges(G.vertexList.getFirst()); j.hasNext();) {
                e =  j.next();
                end=e.getSecondEndpoint();
                int ind=G.vertexList.indexOf(end);
                excess[ind]=(Double)e.getData();
                temp=temp+(Double)e.getData();                
        }
        excess[0]=-temp;
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
    
}
