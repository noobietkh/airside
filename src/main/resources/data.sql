insert into billing_information values(987, 1, 65557812 , 'James' , 'R&D' );
insert into billing_information values(876, 2, 66667812 , 'Michael' , 'Technology' );
insert into billing_information values(765, 3, 67777812 , 'Wendy' , 'Sales' );

insert into company_information values(1,987, 'CompanyA' , 555);
insert into company_information values(2,876, 'CompanyB' , 666);
insert into company_information values(3,765, 'CompanyC' , 777);

insert into customer_information values(555, 95551122, 'Peter'  , 'DepA' , 'OK');
insert into customer_information values(666, 96661122, 'John'   , 'DepB' , 'NOT OK');
insert into customer_information values(777, 97771122, 'Robert' , 'DepC' , 'OK');

insert into transponder_status values(1,sysdate(), sysdate() , 555 , 'Renting' );
insert into transponder_status values(2,sysdate(), sysdate() , 666 , 'Borrowing' );
insert into transponder_status values(3,sysdate(), sysdate() , 777 , 'In-Store' );

insert into vehicle_information values(21, 1, 2188888);
insert into vehicle_information values(22, 2, 2288888);
insert into vehicle_information values(23, 3, 2388888 );

insert into transponder values(71  ,'callsignA', 7171 , 'serialA');
insert into transponder values(72  ,'callsignB', 7272 , 'serialB');
insert into transponder values(73  ,'callsignC', 7373 , 'serialC');
