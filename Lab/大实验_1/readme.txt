1. 程序基本信息
本程序是一个叫做给矩阵上色的游戏。游戏对象时一个15 * 15的矩阵，初始每个格子会有6种颜色中的一种。玩家最多进行15步操作，每次操作可以把左上角以及和左上角颜色一致切联通的格子的颜色修改为指定的颜色。游戏的目标是在29步之内把整个矩阵都修改为同一种颜色。

2. 程序操作
菜单栏start页面下有new game选项，可以重新生成一个随机地图；save选项可以保存当前游戏到一个文件中；load选项可以从一个游戏保存到的文件中还原这个游戏。其中save和load选项都加有文件验证，不会读取错误的文件。
每一步操作可以通过6个按钮调整左上角及其联通的格子的颜色。在29步操作结束之前完成目标则游戏胜利，否则失败。由于这个程序用不到多线程，因此在title部分会用单独线程更新系统时间。

3. 类设计
界面类：继承JFrame
界面左边用7个控件，一个用于显示当前剩余操作数的Label和6个表示不同操作的按钮。界面主要部分是Graphics绘制的游戏主体，用15 * 15个fillRect组成。注册ActionListener来监听菜单操作和游戏操作。

游戏模型类：
包含一个step元素，表示剩余操作步数；一个mat元素，表示棋盘当前状态。
方法包括初始化游戏、判断是否胜利、进行一步操作等。在进行操作时，用了和深度优先搜索类似的方式找到了所有应该修改颜色的块。

枚举类型：
包含6种游戏中用到的颜色。只要更改这个枚举类型就可以同时修改按钮和游戏主体中对应部分的颜色。在扩展功能时，可以通过修改这个枚举类型来达到修改游戏主题的作用。

