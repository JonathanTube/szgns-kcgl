package com.kxm.kcgl.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kxm.kcgl.dao.WarehouseVoucherDao;
import com.kxm.kcgl.domain.WarehouseVoucherBean;

@Repository
public class WarehouseVoucherService {
	@Autowired
	private WarehouseVoucherDao warehouseVoucherDao;

	private class MapKey {
		private String brandName;
		private String productName;
		private String techName;
		private String thicknessName;
		private int amount;

		public MapKey(String brandName, String productName, String techName,
				String thicknessName, int amount) {
			super();
			this.brandName = brandName;
			this.productName = productName;
			this.techName = techName;
			this.thicknessName = thicknessName;
			this.amount = amount;
		}

		@Override
		public boolean equals(Object obj) {
			if ((obj instanceof MapKey) == false) {
				return false;
			}
			MapKey mapKey = (MapKey) obj;
			return mapKey.brandName == brandName
					&& mapKey.productName == productName
					&& mapKey.techName == techName
					&& mapKey.thicknessName == thicknessName;
		}

		@Override
		public int hashCode() {
			int result = 17;
			result = 37 * result + brandName.hashCode();
			result = 37 * result + techName.hashCode();
			result = 37 * result + productName.hashCode();
			result = 37 * result + thicknessName.hashCode();
			return result;
		}

		public String getBrandName() {
			return brandName;
		}

		public String getProductName() {
			return productName;
		}

		public String getTechName() {
			return techName;
		}

		public String getThicknessName() {
			return thicknessName;
		}

		public int getAmount() {
			return amount;
		}
	}

	public Map<String, Object> query(Date date) {
		List<WarehouseVoucherBean> list = warehouseVoucherDao.query(date);
		// 获取当前月份一共有多少天
		Calendar now = Calendar.getInstance();
		int days = getDaysByYearMonth(now.get(Calendar.YEAR),
				now.get(Calendar.MONTH) + 1);
		Map<MapKey, int[]> map = new HashMap<WarehouseVoucherService.MapKey, int[]>();
		for (WarehouseVoucherBean w : list) {
			MapKey mk = new MapKey(w.getBrandName(), w.getProductName(),
					w.getTechName(), w.getThicknessName(), w.getAmount());
			if (map.containsKey(w)) {
				int[] vals = map.get(w);
				String[] d = w.getCreate_time().split("-");
				String _d = d[2];
				if (_d.startsWith("0")) {
					_d = _d.substring(1);
				}
				int _dd = Integer.parseInt(_d) - 1;
				vals[_dd] = w.getAmount();
			} else {
				int[] vals = new int[days];
				String[] d = w.getCreate_time().split("-");
				String _d = d[2];
				if (_d.startsWith("0")) {
					_d = _d.substring(1);
				}
				int _dd = Integer.parseInt(_d) - 1;
				vals[_dd] = w.getAmount();
				map.put(mk, vals);
			}
		}

		List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
		Set s = map.keySet();
		Iterator<MapKey> it = s.iterator();
		while (it.hasNext()) {
			Map<String, Object> m = new HashMap<String, Object>();
			MapKey mk = it.next();
			m.put("brandName", mk.getBrandName());
			m.put("productName", mk.getProductName());
			m.put("techName", mk.getTechName());
			m.put("thicknessName", mk.getThicknessName());
			int[] vv = map.get(mk);
			m.put("data", vv);
			m.put("amount", mk.getAmount() + "");
			result.add(m);
		}

		Map<String, Object> returnResult = new HashMap<String, Object>();
		returnResult.put("size", days);
		returnResult.put("content", result);
		return returnResult;
	}

	private static int getDaysByYearMonth(int year, int month) {
		Calendar a = Calendar.getInstance();
		a.set(Calendar.YEAR, year);
		a.set(Calendar.MONTH, month - 1);
		a.set(Calendar.DATE, 1);
		a.roll(Calendar.DATE, -1);
		int maxDate = a.get(Calendar.DATE);
		return maxDate;
	}

	public static void main(String[] args) {
		System.out.println(getDaysByYearMonth(2008, 2));
	}

}
