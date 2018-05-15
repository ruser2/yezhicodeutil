package com.yllt.com.framework.json;

import java.lang.reflect.Field;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.NameFilter;
import com.alibaba.fastjson.serializer.PropertyFilter;
import com.alibaba.fastjson.serializer.SerializeConfig;
import com.alibaba.fastjson.serializer.SerializeWriter;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.serializer.SimpleDateFormatSerializer;
import com.yllt.com.framework.json.annotation.FirstCharUp;
import com.yllt.com.framework.json.annotation.NotOutput;
import com.yllt.com.framework.json.annotation.NullNotOutput;
import com.yllt.utils.StringUtil;

/**
 * JSON转换器
 * 
 * @author liaoruifeng
 * @2012-7-27
 */
public class JsonConvert {
	private static class TestClass {
		private Date date;

		private String name;

		/**
		 * @return 获取 name
		 */
		@SuppressWarnings("unused")
		public String getName() {
			return name;
		}

		/**
		 * @param 设置
		 *            name
		 */
		@SuppressWarnings("unused")
		public void setName(String name) {
			this.name = name;
		}

		/**
		 * @return 获取 date
		 */
		@SuppressWarnings("unused")
		public Date getDate() {
			return date;
		}

		/**
		 * @param 设置
		 *            date
		 */
		public void setDate(Date date) {
			this.date = date;
		}

		private String isCon = "T";

		@SuppressWarnings("unused")
		public String getIsCon() {
			return isCon;
		}

	}

	public static void main(String[] args) {
		TestClass tc = new TestClass();
		tc.setDate(new Date());
		System.out.println(JsonConvert.toJSONString(tc));
	}

	private static SerializeConfig innerConfig = new SerializeConfig();

	// 默认属性配置
	private static SerializerFeature[] innerFeatures = {
			SerializerFeature.WriteMapNullValue,
			SerializerFeature.DisableCircularReferenceDetect };

	static {
		innerConfig.put(Date.class, new SimpleDateFormatSerializer(
				"yyyy-MM-dd HH:mm:ss"));
		innerConfig.put(Timestamp.class, new SimpleDateFormatSerializer(
				"yyyy-MM-dd HH:mm:ss"));
	}

	public static <T> List<T> toArray(String json, Class<T> clazz) {
		return JSONArray.parseArray(json, clazz);
	}

	/**
	 * JSON转对象
	 * 
	 * @param json
	 * @param clazz
	 * @return
	 */
	public static <T> T toBean(String json, Class<T> clazz) {
		return JSONObject.parseObject(json, clazz);
	}

	public static Object toBeanY(String json, TypeReferenceX type) {
		return JSONObject.parseObject(json, type);
	}

	public static String toJSONString(Object ob) {
		return toJSONString(ob, innerConfig, innerFeatures);
	}

	private static PropertyFilter NullNotOutputPropertyFilter = new PropertyFilter() {

		@Override
		public boolean apply(Object source, String name, Object value) {
			if (source instanceof Map) {
				return true;
			}
			try {
				Class<?> clazz = source.getClass();
				Field filed = clazz.getDeclaredField(name);
				if (filed != null) {
					NullNotOutput nullNotOutput = filed
							.getAnnotation(NullNotOutput.class);
					if (nullNotOutput != null && value == null) {
						return false;
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return true;
		}

	};

	private static PropertyFilter NotOutputPropertyFilter = new PropertyFilter() {
		@Override
		public boolean apply(Object source, String name, Object value) {
			if (source instanceof Map) {
				return true;
			}
			try {
				Class<?> clazz = source.getClass();
				Field filed = clazz.getDeclaredField(name);
				if (filed != null) {
					NotOutput nullNotOutput = filed
							.getAnnotation(NotOutput.class);
					if (nullNotOutput != null) {
						return false;
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return true;
		}

	};

	private static NameFilter FirstCharUpNameFilter = new NameFilter() {

		@Override
		public String process(Object source, String name, Object value) {
			if (source instanceof Map) {
				return name;
			}
			try {
				Class<?> clazz = source.getClass();
				Field filed = clazz.getDeclaredField(name);
				if (filed != null) {
					FirstCharUp firstCharUp = filed
							.getAnnotation(FirstCharUp.class);
					if (firstCharUp != null) {
						return StringUtil.firstToUpper(name);
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return name;
		}

	};

	/**
	 * 对象转JSON格式的字符串
	 * 
	 * @param ob
	 *            对象
	 * @param config
	 *            配置器
	 * @param features
	 *            属性配置
	 * @return
	 */
	private static String toJSONString(Object ob, SerializeConfig config,
			SerializerFeature... features) {
		if (config == null) {
			config = innerConfig;
		}

		if (features == null || features.length <= 0) {
			features = innerFeatures;
		}

		SerializeWriter out = new SerializeWriter();

		try {
			JSONSerializer serializer = new JSONSerializer(out, config);
			for (com.alibaba.fastjson.serializer.SerializerFeature feature : features) {
				serializer.config(feature, true);
			}

			serializer.getPropertyFilters().add(NullNotOutputPropertyFilter);
			serializer.getPropertyFilters().add(NotOutputPropertyFilter);

			serializer.getNameFilters().add(FirstCharUpNameFilter);

			serializer.write(ob);

			return out.toString();
		} finally {
			out.close();
		}
	}
}
