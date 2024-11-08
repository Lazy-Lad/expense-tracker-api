drop database expensetrackerdb;
-- Drop the existing database named "expensetrackerdb".

drop user expensetracker;
-- Drop the existing user named "expensetracker".

create user expensetracker with password 'password';
-- Create a new user named "expensetracker" with the specified password.

create database expensetrackerdb with template=template0 owner=expensetracker;
-- Create a new database named "expensetrackerdb" with template0 and set "expensetracker" as the owner.

\connect expensetrackerdb;
-- Connect to the newly created database "expensetrackerdb".

alter default privileges grant all on tables to expensetracker;
-- Grant all default privileges on tables to the user "expensetracker".

alter default privileges grant all on sequences to expensetracker;
-- Grant all default privileges on sequences to the user "expensetracker".

create table et_users(
    user_id integer primary key not null,
    -- Create an integer primary key column "user_id" that cannot be null.

    first_name varchar(20) not null,
    -- Create a varchar column "first_name" with max length 20 that cannot be null.

    last_name varchar(20) not null,
    -- Create a varchar column "last_name" with max length 20 that cannot be null.

    email varchar(30) not null,
    -- Create a varchar column "email" with max length 30 that cannot be null.

    password text not null
    -- Create a text column "password" that cannot be null.
);

create table et_categories(
    category_id integer primary key not null,
    -- Create an integer primary key column "category_id" that cannot be null.

    user_id integer not null,
    -- Create an integer column "user_id" that cannot be null.

    title varchar(20) not null,
    -- Create a varchar column "title" with max length 20 that cannot be null.

    description varchar(100) not null
    -- Create a varchar column "description" with max length 100 that cannot be null.
);

alter table et_categories add constraint category_users_fk
foreign key (user_id) references et_users(user_id);
-- Add a foreign key constraint on "user_id" in "et_categories" referencing "user_id" in "et_users".

create table et_transactions(
    transaction_id integer primary key not null,
    -- Create an integer primary key column "transaction_id" that cannot be null.

    user_id integer not null,
    -- Create an integer column "user_id" that cannot be null.

    amount numeric(10,2) not null,
    -- Create a numeric column "amount" with precision 10 and scale 2 that cannot be null.

    note varchar(50) not null,
    -- Create a varchar column "note" with max length 50 that cannot be null.

    transaction_date bigint not null
    -- Create a bigint column "transaction_date" that cannot be null.
);

create sequence et_users_seq increment 1 start 1;
-- Create a sequence "et_users_seq" starting at 1 and incrementing by 1.

create sequence et_categories_seq increment 1 start 1;
-- Create a sequence "et_categories_seq" starting at 1 and incrementing by 1.

create sequence et_transactions_seq increment 1 start 1000;
-- Create a sequence "et_transactions_seq" starting at 1000 and incrementing by 1.