package hot100;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class course207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> courses = new ArrayList<>();
        int[] indegree = new int[numCourses];
        for(int i=0;i<numCourses;i++){
            courses.add(new ArrayList<>());
        }
        for(int[] edge : prerequisites){
            int a = edge[0];
            int b = edge[1];
            courses.get(b).add(a);
            indegree[a]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0)
                q.offer(i);
        }
        int cnt = 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                int cur = q.poll();
                cnt++; //这样0也会被计数
                List<Integer> next = courses.get(cur);
                for(int j=0;j<next.size();j++){
                    int m =next.get(j);
                    indegree[m]--;
                    if(indegree[m]==0){
                        q.offer(m);
                    }
                }
            }
        }
        return cnt == numCourses;
    }
}
