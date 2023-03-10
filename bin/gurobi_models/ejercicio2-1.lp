Minimize

10.0 x_0 + 3.0 x_1 + 1.5 x_2 + 5.0 x_3


Subject To

a0: true x_0 + true x_1 + false x_2 + false x_3 >= 1
a1: true x_0 + false x_1 + false x_2 + false x_3 >= 1
a2: true x_0 + false x_1 + false x_2 + false x_3 >= 1
a3: true x_0 + true x_1 + false x_2 + false x_3 >= 1
a4: false x_0 + false x_1 + true x_2 + true x_3 >= 1
b0: y_0 + y_1 <= 1
c0: true x_0 - y_0 <= 0
c1: false x_0 - y_1 <= 0
c2: true x_1 - y_0 <= 0
c3: false x_1 - y_1 <= 0
c4: false x_2 - y_0 <= 0
c5: true x_2 - y_1 <= 0
c6: true x_3 - y_0 <= 0
c7: false x_3 - y_1 <= 0




Binary

y_0 y_1 x_0 x_1 x_2 x_3

 


End
