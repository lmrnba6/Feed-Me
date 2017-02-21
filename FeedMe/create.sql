 create table CART_MEAL (
        MEAL_ID int8 not null,
        CART_ID int8 not null,
        primary key (MEAL_ID, CART_ID)
    );

    create table CREDIT_CARD (
        CREDIT_CARD_ID  bigserial not null,
        cvv int4,
        month int4,
        number int8,
        year int4,
        USER_ID int8,
        primary key (CREDIT_CARD_ID)
    );

    create table FEEDBACK (
        FEEDBACK_ID  bigserial not null,
        COMMENT varchar(255),
        FEEDBACK_DATE date,
        SUBJECT varchar(255),
        RESTAURANT_ID int8,
        USER_ID int8,
        primary key (FEEDBACK_ID)
    );

    
    create table MEAL (
        MEAL_ID  bigserial not null,
        DESCRIPTION varchar(255),
        IS_AVAILABLE boolean,
        MEAL_IMAGE_URL varchar(255),
        MEAL_NAME varchar(255),
        PRICE float8,
        TYPE varchar(255),
        MENU_ID int8,
        primary key (MEAL_ID)
    );

    
    create table MEAL_MEAL_RATING (
        Meal_MEAL_ID int8 not null,
        meal_MEAL_RATING_ID int8 not null,
        primary key (Meal_MEAL_ID, meal_MEAL_RATING_ID)
    );

    
    create table MEAL_RATING (
        MEAL_RATING_ID  bigserial not null,
        RATEDATE date,
        RATINGVALUE int4,
        MEAL int8,
        USER_ID int8,
        primary key (MEAL_RATING_ID)
    );

    
    create table MEAL_SHOPPINGCART (
        Meal_MEAL_ID int8 not null,
        cart_CART_ID int8 not null,
        primary key (Meal_MEAL_ID, cart_CART_ID)
    );

    
    create table MENU (
        MENU_ID  bigserial not null,
        RESTAURANT_ID int8,
        primary key (MENU_ID)
    );

    
    create table MENU_MEAL (
        Menu_MENU_ID int8 not null,
        meal_MEAL_ID int8 not null,
        primary key (Menu_MENU_ID, meal_MEAL_ID)
    );

    
    create table ORDERS (
        ORDER_ID  bigserial not null,
        COMMENT varchar(255),
        PRICE float8,
        STATUS varchar(255),
        user_USER_ID int8,
        primary key (ORDER_ID)
    );

    
    create table ORDERS_MEAL (
        Order_ORDER_ID int8 not null,
        meals_MEAL_ID int8 not null,
        primary key (Order_ORDER_ID, meals_MEAL_ID)
    );

    create table REST_CATEGORY (
        REST_CATEGORY_ID  bigserial not null,
        NAME varchar(255),
        primary key (REST_CATEGORY_ID)
    );
    
    create table REST_RATING (
        REST_RATING_ID  bigserial not null,
        RATE_DATE date,
        RATING_VALUE int4,
        REVIEW varchar(255),
        RESTAURANT_ID int8,
        USER_ID int8,
        primary key (REST_RATING_ID)
    );
    
    create table RESTAURANT (
        RESTAURANT_ID  bigserial not null,
        ADDRESS varchar(255),
        CHARGE_FOR_DELIVERY float8,
        DELIVERY_TIME varchar(255),
        CITY varchar(255),
        CLOSING varchar(255),
        DELIVERY_CHARGE boolean,
        DISCRIPTION varchar(255),
        HOMEDELIVERY boolean,
        NAME varchar(255),
        OPENING varchar(255),
        OWNER_LASTNAME varchar(255),
        OWNER_FIRSTNAME varchar(255),
        PASSWORD varchar(255),
        PHONENUM1 int8,
        PHONENUM2 int8,
        REST_IMAGE_URL varchar(255),
        USERNAME varchar(255),
        ZIP varchar(255),
        REST_CATEGORY_ID int8,
        primary key (RESTAURANT_ID)
    );

    create table SHOPPINGCART (
        CART_ID  bigserial not null,
        price float8,
        size int4,
        user_id int8,
        primary key (CART_ID)
    );

    create table USERS (
        USER_ID  bigserial not null,
        GENDER varchar(255),
        ADDRESS varchar(255),
        BALANCE float8,
        BLOCK boolean,
        CITY varchar(255),
        CREDITCARD int8,
        EMAIL varchar(255),
        ENTRYDATE date,
        FIRSTNAME varchar(255),
        HOMEPHONE int8,
        LASTNAME varchar(255),
        LEVEL varchar(255),
        MOBILE int8,
        STATE varchar(255),
        USERNAME varchar(255),
        USER_PASSWORD varchar(255),
        ZIP varchar(255),
        primary key (USER_ID)
    );

    alter table MEAL_MEAL_RATING 
        drop constraint UK_j582od19lu7udeaxkv1e0ws2t

    
    alter table MEAL_MEAL_RATING 
        add constraint UK_j582od19lu7udeaxkv1e0ws2t unique (meal_MEAL_RATING_ID)

    alter table MENU_MEAL 
        drop constraint UK_f2dsgghxgb68j7mf75f80cviw

    
    alter table MENU_MEAL 
        add constraint UK_f2dsgghxgb68j7mf75f80cviw unique (meal_MEAL_ID)

    
    alter table CART_MEAL 
        add constraint FK293n89vvhrqe7k3232y6kplar 
        foreign key (CART_ID) 
        references MEAL

    
    alter table CART_MEAL 
        add constraint FKs6qvrvikxmrabkhqvsv0bqup4 
        foreign key (MEAL_ID) 
        references SHOPPINGCART

    
    alter table CREDIT_CARD 
        add constraint FKnk7yy4mtquwevc28jgcqgaggh 
        foreign key (USER_ID) 
        references USERS

    
    alter table FEEDBACK 
        add constraint FKbnulcfo184c2mvdvd3vtvuri6 
        foreign key (RESTAURANT_ID) 
        references RESTAURANT
 
    
    alter table FEEDBACK 
        add constraint FKnso3vt6033kgl02bradqvhblv 
        foreign key (USER_ID) 
        references USERS

    
    alter table MEAL 
        add constraint FKl1rfjbd3ayw11sbglp13jrxx4 
        foreign key (MENU_ID) 
        references MENU

    
    alter table MEAL_MEAL_RATING 
        add constraint FKf90x3cqhle0iqrh2sanj09av8 
        foreign key (meal_MEAL_RATING_ID) 
        references MEAL_RATING

    
    alter table MEAL_MEAL_RATING 
        add constraint FK1tqo8bfm1yp6mmiwusgqxi0iu 
        foreign key (Meal_MEAL_ID) 
        references MEAL

    
    alter table MEAL_RATING 
        add constraint FKt9y2tj9r3415y1tjkujoxwlwy 
        foreign key (MEAL) 
        references MEAL

    
    alter table MEAL_RATING 
        add constraint FKqilx3p9sogbw1t7r832uxwvr9 
        foreign key (USER_ID) 
        references USERS

    
    alter table MEAL_SHOPPINGCART 
        add constraint FKe2ceob0qk6lvoxll5al7hjx62 
        foreign key (cart_CART_ID) 
        references SHOPPINGCART

    
    alter table MEAL_SHOPPINGCART 
        add constraint FKibyo8vashihrqftmr5etkr16k 
        foreign key (Meal_MEAL_ID) 
        references MEAL
 
    
    alter table MENU 
        add constraint FKqyi27aw4wpm0ytovpfugby4ed 
        foreign key (RESTAURANT_ID) 
        references RESTAURANT

    
    alter table MENU_MEAL 
        add constraint FKkvq16rb4s8y0ler7noq1w24p4 
        foreign key (meal_MEAL_ID) 
        references MEAL

   
    alter table MENU_MEAL 
        add constraint FKkiomodpfo6jm0h5drt3p2ejfp 
        foreign key (Menu_MENU_ID) 
        references MENU

    
    alter table ORDERS 
        add constraint FKenwru67yr8f0ei6m1bc2xlj4w 
        foreign key (user_USER_ID) 
        references USERS

    
    alter table ORDERS_MEAL 
        add constraint FKrqauyj4ga9y925u1kneuwl53s 
        foreign key (meals_MEAL_ID) 
        references MEAL

    
    alter table ORDERS_MEAL 
        add constraint FKacmx11umfphj07wa059tkp6i9 
        foreign key (Order_ORDER_ID) 
        references ORDERS

    
    alter table REST_RATING 
        add constraint FKovub5bvswfm7vpary2qtodffs 
        foreign key (RESTAURANT_ID) 
        references RESTAURANT
 
    
    alter table REST_RATING 
        add constraint FKmp48bs0b86iotkjb9i04yjen7 
        foreign key (USER_ID) 
        references USERS

    
    alter table RESTAURANT 
        add constraint FKbsoq3fr8vm0dhihc6omc163oj 
        foreign key (REST_CATEGORY_ID) 
        references REST_CATEGORY

    
    alter table SHOPPINGCART 
        add constraint FKlwtri64sk390dc7h8ljb4tyjd 
        foreign key (user_id) 
        references USERS
