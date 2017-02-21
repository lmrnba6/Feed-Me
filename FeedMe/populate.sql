 insert 
    into
        REST_CATEGORY
        (REST_CATEGORY_ID, NAME) 
    values
        (1, 'Middle East');

insert 
    into
        RESTAURANT
        (RESTAURANT_ID, ADDRESS, CHARGE_FOR_DELIVERY, DELIVERY_TIME, CITY, CLOSING, DELIVERY_CHARGE, DISCRIPTION, HOMEDELIVERY, NAME, OPENING, OWNER_LASTNAME, OWNER_FIRSTNAME, PASSWORD, PHONENUM1, PHONENUM2, REST_CATEGORY_ID, REST_IMAGE_URL, USERNAME, ZIP) 
    values
        (1, 'sherbrooke', 10, 10, 'new york', 10, false, 'nothing', true, 'falafel', 10, 'riadh', 'loucif', 1, 1321321, 321321, 1, 'https://www.thermea.ca/app/assets/media/generated/55afa22ff1c80bb4097cb1349324a8fc1320719438_gallery_gallery.jpg?1404322746', 1, '10031');
        
  insert 
    into
        MENU
        (Menu_ID, RESTAURANT_ID) 
    values
        (1,1);
































