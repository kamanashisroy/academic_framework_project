Group 4

Name: Md Habibur Rahman Rony
Student ID: 984582

Name: Kamanashis Roy
Student ID: 984734

Name: Haimanot Kebede
Student ID: 108147 


Framework
===========

Banking framework allows to write flexible banking software. It provides extensibilities by providing the hot-spots. The hot-spots are shown below.

#### Hot-spot for models

| <<Interface>> | IModuleFactory |
| ------------- | ------------- |
| ITransactionFactory | getTransactionFactory() |
| ICustomerFactory | getCustomerFactory()  |
| IAccountListFactory | getAccountListFactory() |


The hot-spots are shown below. Note that the factories described below can be injected by implementing the `IModuleFactory`. Note that all the factories have default implementation.

- It is possible to add new customer by providing `ICustomerFactory` . One example of it is `DefaultCustomerFactory`. 

- It is possible to create new `ITransaction`. It can be done by implementing the `TransactionFactory` . 

- The `IAccountList` can be injected implementing the `IAccountListFactory`.

The `framework.properties` file contains the entry point for `IModuleFactory`.

```
module.factory = framework.module.concrete.DefaultModuleFactory
```


#### Hot-spot for GUI

The GUI can be injected implementing the `IDashBoard`.

The `framework.properties` file contains the entry point for `IDashBoard`.

```
module.dashboard = framework.gui.concrete.DefaultDashBoard
```

The `DefaultDashBoard` can render `SwingDashBoardBlock` dynamically from `framework.properties`.

```
defaultdashboard.header = framework.gui.concrete.DefaultDashBoardHeader
defaultdashboard.content = framework.gui.concrete.DefaultDashBoardContent
defaultdashboard.tools = framework.gui.concrete.DefaultDashBoardTransactionOperation
```


Links
===============

[patterns](patterns.md)

How to run
================


The application takes the properties file argument.

Configure the framework by right click on Finco runAs ->runConfigurations and write framework.properties on the argument section to set the properties.




