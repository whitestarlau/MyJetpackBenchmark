## 这是一个使用jetpack-benchmark的式例。
### Tips：
1. benchmark库只能运行在使用androidx的项目上；
2. 适用范围：基准化分析最适用于应用中频繁运行的 CPU 工作，例如 RecyclerView 滚动、数据转换/处理以及反复使用的代码段。其他类型的代码较难以通过基准化分析进行衡量。可以考虑trace、profiler等手段；
3. 被测试的代码只能是library而不是application。否则会出现找不到类的情况；所以测试的时候可能需要把相应测试代码独立出一个module，所以已有项目使用benchmark并不是完全无痛的。除此之外的侵入性不强；（生成benchmark模块的时候官方注释也注明了这一点）
4. 在android studio 3.5以上版本提供了快速建立benchmark模块的官方引导。 New -> Module -> 选择 Benchmark Module。
5. 只能在真实机器上运行，需要设置debugable = false，并尽量通过可能的手段（比如root）降低设备的cpu动态频率调整（类似“睿频”）。benchmark的运行要保证衡量标准尽可能接近用户真实使用场景，并且变量尽量少；
6. 被测试的lib中的依赖，都要在benchmark中单独拷贝一份；
7. 如果被测试的module配置了databinding这种会在编译时自动生成代码的选项，也要在benchmark的build.gradle中配置一份；
8. 参见我自己的demo，测试在recyclerView中，每个item的layout嵌套层级对于性能的影响；