package com.mr;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.mr.bean.Component;
import com.mr.bean.Event;
import com.mr.bean.Methode;
import com.mr.bean.Para;
import com.mr.bean.Propertie;

public class Main {
	// E:\json
	// E:\do-project.github.io\content\组件API\sections

	public static void main(String[] args) {

		if (args == null) {
			System.err.println("参数不能为空");
			return;
		}

		if (args.length != 2) {
			System.err.println("参数配置错误");
			return;
		}

		String inDirStr = args[0];
		String outDirStr = args[1];

		File inDir = new File(inDirStr);

		if (inDirStr.length() == 0 || !inDir.exists()) {
			System.err.println("json目录不存在，请正确配置第一个参数");
			return;
		}

		File outDir = new File(outDirStr);
		if (outDirStr.length() == 0 || !outDir.exists()) {
			System.err.println("输出目录不能为空，请正确配置第二个参数");
			return;
		}

		StringBuffer tocSb = new StringBuffer();

		File[] inFiles = inDir.listFiles(new FilenameFilter() {

			@Override
			public boolean accept(File dir, String name) {
				if (name.endsWith(".json")) {
					return true;
				}
				return false;
			}
		});

		for (File file : inFiles) {
			StringBuffer sb = new StringBuffer();

			BufferedReader br = null;
			try {
				br = new BufferedReader(new FileReader(file));
				String lineStr = null;
				while ((lineStr = br.readLine()) != null) {
					sb.append(lineStr);
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (br != null) {
					try {
						br.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}

			Component mComponent = JSONObject.parseObject(sb.toString(), Component.class);

			BufferedWriter bw = null;
			// 创建一个名字为ID.md 文件
			File outFile = new File(outDir, mComponent.getID() + ".md");
			try {
				if (!outFile.exists()) {
					outFile.createNewFile();
				}

				bw = new BufferedWriter(new FileWriter(outFile));

				bw.write("---\n");
				bw.write("title: " + mComponent.getID() + " 组件\n");
				bw.write("---\n");
				bw.write("\n");
				bw.write("### " + mComponent.getID() + " 组件\n");
				bw.write("\n");

//				bw.write("* 当前版本: `" + mComponent.getVersion() + "`\n");
//				bw.write("* 支持平台: <font color ='#40A977'>iOS" + mComponent.getIos().getMinVersion() + ",Android" + mComponent.getAndroid().getMinVersion() + "</font>\n");
//				bw.write("* 说明: " + mComponent.getDescription() + "\n");
				bw.write(" 支持平台: iOS" + mComponent.getIos().getMinVersion() + ",Android" + mComponent.getAndroid().getMinVersion() + "\n");
				bw.write(" " + mComponent.getDescription() + "\n");

				bw.write("\n");
				bw.write("#### <font color ='#40A977'>**1.**</font> 属性\n");
				bw.write("\n");

				List<Propertie> mProperties = mComponent.getProperties();
				for (Propertie mPropertie : mProperties) {
					bw.write(">###### <font color ='#42b983'>**" + mPropertie.getID() + "**</font>: " + mPropertie.getName() + "\n");
					bw.write("\n");
					bw.write("- 数据类型 : <font color ='#808000'>**" + mPropertie.getType() + "**</font>\n");
					bw.write("- 默认值 : " + mPropertie.getDefaultValue() + "\n");
					bw.write("- 说明 : " + mPropertie.getDescription() + "\n");

					bw.write("\n");
				}

				bw.write("#### <font color ='#40A977'>**2.**</font> 同步方法\n");
				bw.write("\n");

				List<Methode> syncMethodes = mComponent.getSyncMethodes();
				for (Methode mMethode : syncMethodes) {
					bw.write(">##### <font color ='#0092db'>**" + mMethode.getID() + "**</font>: " + mMethode.getName() + "\n");
					bw.write("\n");

					List<Para> mParas = mMethode.getParas();
					if (mParas.size() <= 0) {
						bw.write("- 参数: **无**\n");
					} else {
						bw.write("- 参数:\n");
						bw.write("\n");
						bw.write("  名称 | 类型 |必填|默认值|说明\n");
						bw.write("  ---- |-------------  |--------------|--------|------\n");

						for (Para mPara : mParas) {
							bw.write("  **" + mPara.getID() + "** |<font color ='#808000'>**" + mPara.getType() + "**</font> | " + mPara.getRequired() + " | " + mPara.getDefaultValue() + "|"
									+ mPara.getDescription() + "\n");
						}
					}

					// bw.write("- 返回值类型: **" + mMethode.getReturnType()
					// +"**\n");
					bw.write("- 返回值类型 : <font color ='#808000'>**" + mMethode.getReturnType() + "**</font>\n");
					bw.write("- 返回值描述: " + mMethode.getReturnDesc() + "\n");
					bw.write("- 说明: " + mMethode.getDescription() + "\n");
					bw.write("- 示例:\n");
					bw.write("\n");

					bw.write("  ```javascript\n");
					bw.write("  ...\n");
					bw.write("\n");
					bw.write("  ```\n");

					bw.write("\n");
					bw.write("[回到顶部](#top)\n");
					bw.write("\n");

				}

				bw.write("#### <font color ='#40A977'>**3.**</font> 异步方法\n");
				bw.write("\n");

				List<Methode> asyncMethodes = mComponent.getAsyncMethodes();
				for (Methode mMethode : asyncMethodes) {
					bw.write(">##### <font color ='#0092db'>**" + mMethode.getID() + "**</font>: " + mMethode.getName() + "\n");
					bw.write("\n");
					List<Para> mParas = mMethode.getParas();
					if (mParas.size() <= 0) {
						bw.write("- 参数: **无**\n");
					} else {
						bw.write("- 参数:\n");
						bw.write("\n");
						bw.write("  名称 | 类型 |必填|默认值|说明\n");
						bw.write("  ---- |-------------  |--------------|--------|------\n");

						for (Para mPara : mParas) {
							bw.write("  **" + mPara.getID() + "** |<font color ='#808000'>**" + mPara.getType() + "**</font> | " + mPara.getRequired() + " | " + mPara.getDefaultValue() + "|"
									+ mPara.getDescription() + "\n");
						}
					}

//					bw.write("- 返回值类型: **" + mMethode.getReturnType() + "**\n");
					bw.write("- 返回值类型 : <font color ='#808000'>**" + mMethode.getReturnType() + "**</font>\n");
					bw.write("- 返回值描述: " + mMethode.getReturnDesc() + "\n");
					bw.write("- 说明: " + mMethode.getDescription() + "\n");
					bw.write("- 示例:\n");
					bw.write("\n");

					bw.write("  ```javascript\n");
					bw.write("  ...\n");
					bw.write("\n");
					bw.write("  ```\n");

					bw.write("\n");
					bw.write("[回到顶部](#top)\n");
					bw.write("\n");

				}

				bw.write("\n");

				bw.write("#### <font color ='#40A977'>**4.**</font> 事件\n");
				bw.write("\n");

				List<Event> mEvents = mComponent.getEvents();

				for (Event mEvent : mEvents) {
					bw.write(">###### <font color ='#e96900'>**" + mEvent.getID() + "**</font>: " + mEvent.getDescription() + "\n");
					bw.write("\n");

//					bw.write("- 返回值类型: " + mEvent.getReturnType() + "\n");
					bw.write("- 返回值类型 : <font color ='#808000'>**" + mEvent.getReturnType() + "**</font>\n");
					bw.write("- 返回值描述: " + mEvent.getReturnDesc() + "\n");
					bw.write("- 说明: " + mEvent.getDescription() + "\n");

					bw.write("- 示例:\n");
					bw.write("\n");

					bw.write("  ```javascript\n");
					bw.write("  ...\n");
					bw.write("\n");
					bw.write("  ```\n");

					bw.write("\n");
					bw.write("[回到顶部](#top)\n");
					bw.write("\n");
				}

				bw.write("\n");
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				if (bw != null) {
					try {
						bw.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}

			// 配置 - do_Http2 toc.yml
			tocSb.append("    - " + mComponent.getID() + "\n");
			System.out.println(" Component = " + mComponent.getID());
		}

		File tocFile = new File(inDirStr, "toc.yml");
		BufferedWriter bw = null;
		try {
			if (!tocFile.exists()) {
				tocFile.createNewFile();
			}

			bw = new BufferedWriter(new FileWriter(tocFile));
			bw.write(tocSb.toString());

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (bw != null) {
				try {
					bw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		System.out.println("Over");
	}
}
