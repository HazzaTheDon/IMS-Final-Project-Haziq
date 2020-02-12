package com.qa.ims.controller;

	import java.util.List;

	import org.apache.log4j.Logger;

	import com.qa.ims.persistence.domain.Item;
	import com.qa.ims.services.CrudServices;
	import com.qa.ims.utils.Utils;

	/**
	 * Takes in item details for CRUD functionality
	 *
	 */
	public class ItemController implements CrudController<Item>{

		public static final Logger LOGGER = Logger.getLogger(ItemController.class);
		
		private CrudServices<Item> itemService;
		
		public ItemController(CrudServices<Item> ItemService) {
			this.itemService = itemService;
		}
		
		String getInput() {
			return Utils.getInput();
		}
		
		/**
		 * Reads all items to the logger
		 */
		@Override
		public List<Item> readAll() {
			List<Item> items = itemService.readAll();
			for(Item item: items) {
				LOGGER.info(item.toString());
			}
			return items;
		}

		/**
		 * Creates a customer by taking in user input
		 */
		@Override
		public Item create() {
			LOGGER.info("Please enter item name:");
			String Name = getInput();
//			LOGGER.info("Please enter a surname");
//			String surname = getInput();
			Item item = itemService.create(new Item(Name));
			LOGGER.info("Item successfully created");
			return item;
		}

		/**
		 * Updates an existing item by taking in user input
		 */
		@Override
		public Item update() {
			LOGGER.info("Please enter the id of the item you would like to update");
			Long id = Long.valueOf(getInput());
			LOGGER.info("Please enter item name");
			String Name = getInput();
//			LOGGER.info("Please enter a surname");
//			String surname = getInput();
			Item item = itemService.update(new Item(id, Name));
			LOGGER.info("Item successfully Updated");
			return item;
		}

		/**
		 * Deletes an existing item by the id of the item
		 */
		@Override
		public void delete() {
			LOGGER.info("Please enter the id of the item you would like to delete");
			Long id = Long.valueOf(getInput());
			itemService.delete(id);
		}
		
	}



