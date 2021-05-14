# PROJECT TITLE
Collateral Loans – Risk Assessment

# OVERVIEW
The project title **COLLATERAL LOANS** refers to any asset or property or cash where a consumer promises to a Bank as backup in exchange for a loan. Collateral Loans can be two types, first comes asset or property loan which is **COLLATERAL REALESTATE** and other one is **COLLATERAL CASHDEPOSIT** for cash loan. There will be a user interface from which back office stuff can access all the loan related instances. This Loan will only be accessable by the *ADMIN* only. Not developed for *CLIENT* service yet.

# REQUIRMENTS
+ Spring Tool Suite (STS) Or any Latest Eclipse
	+ Have PMD Plugin, Code Coverage Plugin and AWS Code Commit Enabled
	+ Configure Maven in Eclipse
+ Maven
+ Postman Client in Chrome

#REQUIRED SERVICES
+ Loan Management Microservice
+ Collateral Management Microservice
+ Risk Assessment Microservice
+ Portal Loans (User Interface for Back Office Stuffs)

#SCOPE
+ **AUTHORIZATION Microservice**
	+ Service to Service communication has to happen using JWT.
	+ The Token will expire after 15 minutes of Login.
	+ Will be invoked from All Microservice for security.
>  **REST End Points**
>	 Post: /login (UserCredentials)
>	 GET: /getValidity (JWT Token)

+ **Collateral Management Microservice**
	+ One of the Core Microservice among all. This Microservice will be invoked by Loan Management Service and Risk Assessment Service.
	+ Can not be accessable from UI Portal.
	+ Can be invoked from Loan Management Service or from Risk Assessment Service.
>  **REST End Points**
>	 GET: /getCollaterals(Input LoanID)
>	 POST: /saveCollaterals(Input CollateralLoans)

+ **Loan Management Microservice**
	+ Loan Management Microservice will be invoked from Collateral Loans Portal. This Microservice will be invoke Collateral Management Service for saving the Collaterals related to the loan.
	+ Can be invoked from Collaterals Loan Portal, however for saving collaterals, this will in turn invoke the Collateral management microservice.
>  **REST End Points**
>	 GET: /getLoanDetails (Input: LoanID)
>	 POST: /saveCollaterals(Input CollateralLoans)
	+ Saving the Collaterals for every input request must happen in parallel

+ **Risk Management Microservice**
	+ Risk Assessment Microservice interacts with Collaterals Management Microservice.
	+ This Microservice will help to determine the risk on that particular loan.
	+ Risk involved in Cash Deposit interest and Real Estate both
	+ If normal Risk on the Loan is 100%. It may varry according to the current market value.
	+ Market value will be written inside the text.txt file
>  **REST End Points**
>	 GET: /getCollateralRisk (Input: LoanID)
>	 GET: /updateCollateralMarketValue()

# USER INTERFACE (UI)
- Collateral Loans Portal Designed Using **Spring MVC Framework** and for Front-End Design **BootStrap-4** used here.
- Collateral Loans Portal must allow a Back Office Staff to Login. Once successfully logged in, the staff can do the following operations -
>	 View Loan Details
>	 Save Collaterals Cash Deposit
>	 Save Collaterals RealEstate
>	 View Risks Associated with the Collateral
- Portal will run in Localhost:9010
