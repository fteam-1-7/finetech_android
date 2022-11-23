# Finetech_Android
Fintech team 17 project is a  Peer-to-peer payment application that allows users to make purchases using any major credit, debit, or gift card network, along with bank account information via third-party APIs like Stripe or PayPal, on Android smartphones or tablets.


# ================MOBILE PAYMENT PLATFORM=====================


There are two ideas we are considering:
1. A mobile payment that allows the transfer of money from one currency to another currency.
2. A DEMO Bank that does only debit and credit.

# USE CASE 1: A mobile payment that does the transfer of money from one currency to another currency rides can be summarized as followed....
User Authentication ==> deposit/withdraw money (credit/debit) ==> conversion of the money to the currency you want to transfer the money to (the rates changes daily) ==> transaction initiated to the beneficiary's account ==> transaction completed and beneficiary receives payment.

# USE CASE 2: A DEMO bank that does only debit and credit can be summarized as follows........
User Authentication ==> money mapped to user's account ==> user's initiate transaction to another user on the database ==> completes transaction ==> beneficiary confirms the payment.

Below is a pictoral flow for NUMBER 2

![image](https://user-images.githubusercontent.com/104723328/201541495-b8fa92c5-61e5-4ecb-961a-16c083b20fa3.png)


A mobile payment that does the transfer of money from one currency to another currency rides can be summarized as followed....

User Authentication ==> deposit/withdraw money (credit/debit) ==> conversion of the money to the currency you want to transfer the money to (the rates changes daily) ==> transaction initiated to the beneficiary's account ==> transaction completed and beneficiary receives payment.

BACKGROUND
Technology is one of the liveliest exposure that have happened to man. It keeps looking for ways to make human's life easy.

Mobile Payment Platform is a P2P (person to person) transaction solution. It handles deposit/credit of money into the holder's account.

PROJECT COMPONENT
*Android Application
*Firebase API & Authentication
*VM to host the Application
*Google Cloud Platform
*Stripe

**ANDROID APPLICATION
The Android Application is built and compiled by Kotlin. It will be deployed/hosted on a VM in our GCP environment. The application is an interface for the users (registered or new) to access his account.

The application has various interface that contains the sign up page, the login page, user's personal transaction page, and so on. Screenshots of the application interface will be shared below.

**Firebase API & Authentication
