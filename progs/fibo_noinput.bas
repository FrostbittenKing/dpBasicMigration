1 let F = 100
2 let O = 0
10 gosub 20
11 print n
12 end
20 if (F = 1) OR (F = 2) then gosub 30
21 let a = 1
22 let b = 1
23 for c = 3 to F step 1
24 n = a + b
25 a = b
26 b = n
27 next c
90 if (F = 1) goto 25
28 return
30 n = 1
32 return
