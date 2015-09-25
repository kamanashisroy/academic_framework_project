
The framework uses patterns in different sections.

#### Command pattern

###### Transaction Scenario

All the `ITransaction` implementations are `Command`s. And the `ITransactionManager` is the `CommandManager` or the `Invoker`. The `Account` and the `IAccountList` are the `receivers`.


#### Observer pattern

###### The ModelChangeListener<IAccountList> for IAccountList

The `IActionList` is the `subject`. Typically, the `DefaultAccountTableModel` is the `observer`.

###### The ModelChangeListener<IAccount> for IAccount

The `IAccount` is the `subject`. Typically, the `IAccountList` is the `observer`.

#### Factory method pattern

###### createAccount in ICustomer

The `ICustomer` creates `IAccount`. It does the creation in application specific way. Here the derived factory is `Company` and `Person` . And the target object is `DefaultAccount`.

#### Abstract Factory Pattern

###### ModuleFactory 

The ModuleFactory contains a group of factories which create objects in application specific way.

#### Composite pattern

###### The IOrganization in banking 

The `IOrganization` can contain multiple `ICustomer`. Here `ICustomer` is the component.
`Person` is the leaf node. And `IOrganization` and `Company` is the composite.

#### MVC

The project implements the pure MVC architecture.

| Model | View | Controller |
|-------|------|------------|
| IAccountList |  |  |
|              | DefaultAccountDialog |  |
|              | DefaultDashBoardHeader |  |
| DefaultAccountTableModel | DefaultDashBoardContent |  |
|  | DefaultDashBoardTransactionOperation |  TransactionController  |

#### Proxy pattern

Proxy pattern is used to wrap the withdraw and deposite and send emails to the company and person.

 




