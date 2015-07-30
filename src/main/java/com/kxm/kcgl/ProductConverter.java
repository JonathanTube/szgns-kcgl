package com.kxm.kcgl;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import org.apache.commons.lang.StringUtils;

import com.hyjd.frame.psm.spring.SpringBeanFetcher;
import com.kxm.kcgl.domain.Product;
import com.kxm.kcgl.service.ProductService;

/**
 *
 * @author kongxm
 * @date 2015 2015年7月30日 下午5:30:57
 */
@FacesConverter("productConverter")
public class ProductConverter implements Converter {

	public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
		if (value != null && value.trim().length() > 0) {
			try {
				ProductService service = (ProductService) SpringBeanFetcher.getBean("productService");
				if (StringUtils.isEmpty(value)) {
					return null;
				}
				return service.queryByProductId(Integer.parseInt(value));
			} catch (NumberFormatException e) {
				throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversion Error", "Not a valid product."));
			}
		} else {
			return null;
		}
	}

	public String getAsString(FacesContext fc, UIComponent uic, Object object) {
		if (object != null) {
			return String.valueOf(((Product) object).getId());
		} else {
			return null;
		}
	}
}
