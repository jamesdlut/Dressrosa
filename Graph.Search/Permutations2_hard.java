/*
Permutations II
Given a collection of numbers that might contain duplicates, return all possible unique permutations.
For example,
[1,1,2] have the following unique permutations:
[1,1,2], [1,2,1], and [2,1,1].
*/
/*
SOL 1
For deal with the duplicate solution, we should sort it.
递归以及回溯
*/
/*
/*
SOL 1
dfs()
   visit[0] = true
   list.add(1)
   dfs()
      visit[2] = true
      list.add(2)
      dfs()
      list.remove(2 - 1)
      visit[2] = false
    list.remove(0)
    visit[0] = false

    visit[1] = true
    list.add(1)
    dfs()
       visit[0] = true
       list.add(1)
       dfs()
          visit[2] = true
          list.add(2)
          dfs()
             rst.add(list) [[1, 1, 2]]
          list.remove(2)
          visit[2] = false
       list.remove(1)
       visit[0] = false
       visit[2] = true
       list.add(2)
       dfs()
          visit[0] = true
          list.add(1)
          dfs()
             rst.add(list) [[1, 1, 2] [1, 2, 1]]
     list.remove(0)
     visit[1] = false
     
     visit[2] = true
     list.add(2)
     dfs()
        visit[0] = true
        list.add(1)
        dfs()
        list.remove(2 - 1)
        visit[0] = false
        visit[1] = true
        list.add(1)
        dfs()
           visit[0] = true
           list.add(1)
           dfs()
              rst.add(list) [[1, 1, 2] [1, 2, 1] [2, 1, 1]]
           ...
        ...
      ...
*/
*/
