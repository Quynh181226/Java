create database if not exists Tranfer;
use Tranfer;

create table Accounts (
    AccountId varchar(10) primary key,
    FullName nvarchar(50),
    Balance decimal(18, 2)
);

insert into Accounts (AccountId, FullName, Balance)
values
    ('ACC01', 'Nguyen Van A', 5000),
    ('ACC02', 'Tran Thi B', 2000);

delimiter //
create procedure sp_UpdateBalance (
    in id varchar(10),
    in amount decimal(18, 2)
)
begin
update Accounts
set Balance = Balance + amount
where AccountId = id;
end //

delimiter ;