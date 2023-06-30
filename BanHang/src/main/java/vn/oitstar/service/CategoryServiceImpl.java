package vn.oitstar.service;

import java.io.File;
import java.util.List;
import java.util.Locale.Category;
import vn.oitsstar.dao.impl.CategoryDAOImpl;
import vn.oitstar.dao.CategoryDaoo;
import vn.oitstar.model.CategoryModel;

public class CategoryServiceImpl implements CategoryService {
	CategoryDaoo categoryDao = new CategoryDAOImpl();
	@Override
	public void insert(Category category) {
		categoryDao.insert(category);
		
	}

	 public void edit(CategoryModel  newcategory) {
       categoryDao.edit(newcategory);

		/*
		 * CategoryModel oldCategory = categoryDao.get(id);
		 * oldCategory.setCname(newcategory.getCname()); if(newcategory.getIcons() !=
		 * null ) { String fileName = oldCategory.getIcons(); final String dir = "D://";
		 * File file = new File (dir + "/category/" + fileName); if (file.exists()) {
		 * file.delete(); } oldCategory.setIcons(newcategory.getIcons()); }
		 * categoryDao.edit(oldCategory);
		 * 
		 */}
	public void delete(int id) {
		categoryDao.delete(id);
		
	}

	@Override
	public Category get(int id) {
		return categoryDao.get(id);
	}

	@Override
	public Category get(String name) {
		return categoryDao.get(name);
	}

	@Override
	public List<Category> getAll() {
		return categoryDao.getAll();
		
	}

	@Override
	public List<Category> search(String keyword) {
		return categoryDao.search(keyword);
	}

	@Override
	public void edit(Category category) {
		// TODO Auto-generated method stub
		
	}

	
}

	


