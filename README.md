# TDD Exercise

## Step1 列出目录下的文件个数
   * Task1 建立MainApp骨架，在intellij里配置用参数传入path参数，打印参数
   * Task2 驱动出CodeAnalyzer类，提供fileCounts方法，默认返回-1
   * Task3 为CodeAnalyzer类生成单元测试类，建立测试目录src/test/fixture/1.java，写单元测试，验证是否返回文件个数为1（此时测试应该通不过）
   * Task4 实现功能，使测试通过
   * Task5 做一点点重构，清理代码
   * Task6 处理一下path不存在的情况，先写测试，后写实现
   * Task7 处理一下path不是目录的情况，先写测试，后写实现

## Step2 应该能够递归遍历目录，列出文件
   * Task1 修改src/test/fixture，增加目录sub1/2.java
   * Task2 修改单元测试，应该返回2个文件（此时测试应该不通过，结果却通过了，原因是之前的实现没有判断是否目录）
   * Task3 修改功能代码，使测试不通过
   * Task3 增加sub1/3.java，修改单元测试，应该返回3个文件（此时测试应该不通过）
   * Task4 修改功能代码，使测试通过



