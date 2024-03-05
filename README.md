# LazyAnFuZai

#### 摸鱼安服工具   ： 

安服吗喽化工具

LazyAnFuZai           -----by   R4gd0ll

#### 模块

简易系统检查

环境：linux（centos7）

功能：收集系统信息，参照检查项初步进行比对，部分检查项需要人工修改

<img src="https://github.com/R4gd0ll/LazyAnFuZai/blob/main/image/image-20240305111954552.png" alt="image-20240305111954552" style="zoom: 67%;" />

值守日报报表

功能：写简易值守日报

<img src="https://github.com/R4gd0ll/LazyAnFuZai/blob/main/image/image-20240305112611893.png" alt="image-20240305112611893" style="zoom:67%;" />

#### 使用说明

##### 简易系统检查

一、点击生成脚本，get到check.sh，传入linux服务器中

```
chmod 777 check.sh
./check.sh 2>&1
```

得到test.txt点击文件导入脚本中，并提交后可查看结果，操作后可对结果进行修改

<img src="https://github.com/R4gd0ll/LazyAnFuZai/blob/main/image/image-20240305113532102.png" alt="image-20240305113532102" style="zoom:67%;" />

导出报告

<img src="https://github.com/R4gd0ll/LazyAnFuZai/blob/main/image/image-20240305113707170.png" alt="image-20240305113707170" style="zoom:67%;" />

##### 值守日报报表

二、

1. 根据值守实际情况进行填写基本情况，并保存

2. 选择事件并填写事例，并提交（每个事件填写完后均需提交保存）

3. 导出word文档、导出config.conf文件
4. 导入config.conf文件，可在工具中查看具体事件事例

<img src="https://github.com/R4gd0ll/LazyAnFuZai/blob/main/image/124df80140badb773687ac604ac5d91.png" alt="124df80140badb773687ac604ac5d91" style="zoom:67%;" />

报告样本

<img src="C:\Users\34540\Documents\WeChat Files\wxid_kzbocsvasgqc22\FileStorage\Temp\4d7663fffdf964caf781425b6c7bece.png" alt="4d7663fffdf964caf781425b6c7bece" style="zoom:67%;" />

导入config.conf文件

<img src="https://github.com/R4gd0ll/LazyAnFuZai/blob/main/image/image-20240305114317798.png" alt="image-20240305114317798" style="zoom:67%;" />
