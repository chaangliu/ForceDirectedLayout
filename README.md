## 描述
>Force-Directed Layout algorithms are graph drawing algorithms based only on information contained within the structure of the graph itself rather than relying on contextual information.

力导向布局算法是一类绘图算法，它仅仅基于图的解构本身来绘图，而不依赖于上下文信息。

[力导向绘图 (Force-directed graph drawing)](https://en.wikipedia.org/wiki/Force-directed_graph_drawing)可以用于描述关系图的结点之间的关系，把结点分布到画布上合理的位置，比如描述企业之间的关系，社交网络中的人际关系等。

## 原理
### 斥力(Repulsive Force)
把每个节点看做一个电荷，电荷与电荷之间存在斥力，也就是库仑力，根据库仑定律( [Coulomb's law](https://en.wikipedia.org/wiki/Coulomb%27s_law "Coulomb's law"))，电子之间的斥力可以这么计算：
![Coulomb's law](https://upload-images.jianshu.io/upload_images/3326381-7357589396de7639.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

假设每个电子的电量都是1，那就有:
>F = k/r<sup>2</sup>.

常数k可以根据画布大小和电子数量计算。
由于需要更新x,y坐标，可以分别计算斥力产生的正向位移。
```
displacementX =  distX / dist * k * k / dist * ejectFactor
```
*关于计算x, y偏移和常数k的方式，可能并没有特别明确的方式，这里可能并不是最优的方法。

### 引力(Traction Force)
一些粒子之间被一些边所牵连，这些边产生类似弹簧的胡克引力：
>Fs=ks(x−x0)

牵制着边两端的粒子。斥力和引力不断作用，粒子在不断位移之后趋于平衡，逐渐不再发生相对位移，能量不断消耗，最终趋于零。


在引力和斥力地作用下不断地更新坐标，经过多次迭代达到一个稳定状态，收敛结束。参数和迭代次数需要
调试。


分别用Java和JavaScript简单实现了这个算法，利用[D3](https://bl.ocks.org/mbostock/4557698)做图形化展示，下面是一些跑出来的数据呈现出的分布图：

![Graph 1. Iteration simulation of 24 nodes.](https://upload-images.jianshu.io/upload_images/3326381-bd63ba0e18ed8cd3.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)
Graph 1. Iteration simulation of 24 nodes.

![Graph 2. Randomly generated 20 nodes, each having 1~7 links.](https://upload-images.jianshu.io/upload_images/3326381-079db14045a33e5f.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)
Graph 2. Randomly generated 20 nodes, each having 1~7 links.

![Graph 3. Simulation of 100 nodes, iterating for 200 times.](https://upload-images.jianshu.io/upload_images/3326381-c0fa4820e7dd5ea5.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)
Graph 3. Simulation of 100 nodes, iterating for 200 times.

---
Refs:

[1]https://www.ibm.com/developerworks/cn/web/0909_fudl_flashsocial/#major3

[2]http://zhenghaoju700.blog.163.com/blog/static/13585951820114153548541/

[3]https://blog.csdn.net/newworld123made/article/details/51443603

[4]http://philogb.github.io/blog/2009/09/30/force-directed-layouts/

[5]https://bl.ocks.org/mbostock/4557698

