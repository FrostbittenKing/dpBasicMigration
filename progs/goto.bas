1 let F = 0
2 let O = 0
10 goto 20
11 goto 29
30 n = 1
20 if (F = 1) OR (F = 2) goto 29
21 let a = 1
22 let b = 1
23 for c = 3 to F step 1
24 n = a + b
25 a = b
26 b = n
27 next c
28 goto 20
29 let lol = 1
