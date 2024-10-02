<template>
  <div class="detail-content">
    <div class="res-login-header">
      <img
        src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAABQAAAAUCAYAAACNiR0NAAABR0lEQVQ4T63UsUrDUBQG4P80vQguVRcHZxFXqbg6iJtP4KzQRSp1SEHhlgy2DhbaQegj1DcwSHUVJys+gC8gQorEJjlyA5WWpLkxMVu44Tvn3v/kEv75oTTeiXW1zn5BdOXZm+57LagwwBgws0G+t9NpmO9JaCI4wQCsMXN/GDiHD1J6mcAsmCoU22FWLBbMg0XAvNgMWLFaGwLFexUAwP0XXx9AXDjhGVat9maAYABgVb0z+JWAxDSnMSZ67p7Xjn47PJXXK57BNgFbusGds/7Yuajtzmy5KttLfsG/I6JtZgwD9+tgJLzPNAVGgHcrpRMJ5bjZLC18F+0QBZ5cZ7zfa5mp0EnhyBzmRWMHO9y+EagzLf+107n/clY08XLIgmqvr4p5uSwWhc1E7IrxXs9MDkkLqvQUihJwU69/6MYoFahDptd/ANUGwhUwnh1lAAAAAElFTkSuQmCC"
        class="type"
        @click="goBack"
      />
      <p>{{ name }}</p>
    </div>

    {{ content }}
  </div>
</template>

<script>
export default {
  data() {
    return {
      name: "",
      content: "",
      content1: `Orbiter Account Terms and Conditions
                   1. Orbiter Account
                   1. These Orbiter Account Terms and Conditions are between you (the account holder) and Orbiter. By using your Orbiter Account, Card and the app, you are agreeing to these terms.
                   2. The Orbiter Account is an e-money product so is not protected by the Financial Services Compensation Scheme (FSCS). However, your funds are held in a segregated account, which may only be used for the purpose of holding customer funds, and which is protected by safeguarding requirements under the Electronic Money Regulations 2011. These protections mean that in the unlikely event Orbiter TECH CO,. LTD became insolvent, the return of customer funds would take priority over all other creditors and uses other than in one respect, which is the cost of the insolvency proceedings. However, you should be aware that in an unusually severe insolvency event, some or all of your funds could be at risk and you could lose your money.
                   3. Your Orbiter Account is an e-money account with additional features, including Direct Debits and Faster Payments.
                   4. Your Orbiter card is a VISA card provided by Orbiter TECH CO,. LTD.
                  5. Protecting your privacy is very important to us. Please review our Privacy Notice to understand our commitment to maintaining your privacy. It also contains important information on the personal data we collect about you, how we process your personal data and who your personal data might be shared with.
                  6. Your agreement with us includes these terms, along with the Orbiter TECH Terms and Conditions and our Privacy Notice. You can request a copy of any of these documents, by contacting us.
                  7. Definitions
                  In these terms and conditions, the following words and phrases have the meanings shown next to them:
                  Continuous Payment Authority or Recurring payment – When you have given a company permission to regularly take money from your card; the company can request payment from your card whenever it is deemed that you owe them money
                  Direct Debit – The customer permits someone else (recipient) to instruct the account provider to transfer money from the customers account to that recipient. The account provider then transfers money to the recipient on a date or dates agreed by the customer and the recipient. The amount may vary
                  E-money – Electronic money: the electronically stored monetary value of funds held in your Orbiter Account. Funds received into your Orbiter Account may be used for the purpose of making payments or transactions outside of Orbiter and its partners. E-money will be referred to throughout these terms and conditions as 'money'. For regulatory purposes, where money is referred to in this document, this denotes 'e-money'
                  Fees – A variety of charges that can be raised for purchase and ongoing use of the Orbiter Card and Orbiter Account
                  Main account – The first account you were issued with when you applied for a Orbiter Account.
                  PIN – Personal identification number, i.e. the security number provided for use with the card and may be required to complete a transaction
                  Recipient – Also known as a payee. A party that you send a payment to from your Orbiter Account. You can choose whether you would like to save a recipient to your Orbiter Account for ease of payments to this party in the future or you can choose to input the recipient’s details for each payment
                  Standing order – The account provider makes regular transfers, on the instruction of the customer, of a fixed amount of money from the customers account to another account.
                  Supplier – A retailer, merchant or other supplier of goods and/or services that accepts payment by means of a card, card number, PIN or card and signature
                  Supplier’s bank – the organisation used by the supplier for the purposes of receiving payments arising from transactions
                  Transfer/Payment – A payment to or from your Orbiter Account. A transfer can be a one-off payment or a regular automated payment such as a standing order or direct debit. Payments that you can make from your Orbiter Account include card payments, direct debits, standing orders, single payments, ATM withdrawals and continuous payment authorities. Payments can be made out of your Orbiter Account by inputting your details online, over the phone or in person. Payments in to your Orbiter Account include Faster Payments in, Orbiters payments in, transfers in from another Orbiter Account or Extra Account or cash payment in
                  Orbiter Account – This is your e-money account as a whole which includes the main account you were issued with when applying, along with any other Extra Accounts you may have set up
                  Orbiter Card – A prepaid Visa Debit card provided for use with your Orbiter Account
                  Verifying your identity – The confirmation of your personal identity and information through checks performed when you open your Orbiter Account or upon requests for further information
                  Website – The website, Orbiter.one, operated by Orbiter TECH CO,. LTD.
                  Working day – A day between and including Monday to Friday, between 9am and 5pm (UK time) and Saturdays between 10am and 5pm (UK time) except for bank or public holidays in England and Wales
                  You/your – The person who has opened a Orbiter Account and is authorised to use the card and account as provided for in this agreement
                  3. Account set up and access
                  3.1 You must be 18 or over and a UK resident to open and hold a Orbiter Account.
                  3.2 To comply with current regulations regarding Strong Customer Authentication, you must have a mobile phone to set up this account.
                  3.3 Applications for a Orbiter Account are only available through our website or mobile app. For all the information you need to provide when applying and why we take this information, please read our Privacy Notice.
                  3.4 Upon verifying your identity and being accepted for a Orbiter Account you will be issued with a Orbiter virtual Card and an account number.
                  4. Account use
                  4.1 Your Orbiter Account is a personal account and it should not be used for business purposes.
                  4.2 We reserve the right to restrict or limit the ability to use the Orbiter Account for gambling and investing, including trading in cryptocurrency or other currencies.
                  4.3 We reserve the right to request information at any time regarding the source of the funds used to pay into your Orbiter Account. We may also suspend use of the account/card where this is the case, pending the satisfactory resolution of our queries.
                  4.4 We may close, suspend or restrict your account, card or PIN on reasonable grounds relating to:
                  4.4.1 the security of your account, card, card number or PIN;
                  4.4.2 the suspected unauthorised or fraudulent use of your account, card or PIN;
                  4.4.3 or at our discretion if you abuse our staff in any way;
                  4.4.4 the deliberate use of your account or card to make payments that exceed your available funds, leaving you with a negative balance.
                  4.5 We will, if possible, inform you before stopping, suspending or restricting your account, card or PIN that we intend to do so and the reasons for doing this. If we are unable to do so then we will inform you immediately afterwards. The requirement to inform you does not apply where it would compromise reasonable security measures or it would be unlawful to do so.

                  5 Making Payments
                  5.1 All information on making payments from your Orbiter Account can be found by logging in to your account.
                  5.2 You must make sure that you have enough money in your account to make a payment, including any fees we may charge you. Payments due to leave your Orbiter Account where there are not sufficient funds to cover both the payment and the fee for the payment will decline.
                  5.3 If you send a payment to an account using incorrect details, we will help you in attempting to retrieve the funds. We offer no guarantee that the funds can be retrieved.
                  5.4 We may refuse to make a payment if:
                  5.4.1 it is not in accordance with these terms and conditions and the information provided on the website, or
                  5.4.2 if the fees applicable would take you into negative balance, or
                  5.4.3 if the payment is to an organisation to which payments are proscribed by law, or
                  5.4.4 if the payment is to an organisation to which we are unable to make payments.
                  5.5 You may choose to temporarily block your Orbiter Card on the website or the app through the card management area. This is the action to ‘freeze’ your card. If you have frozen your Orbiter Card, payments cannot be made from your Orbiter Card. You can choose to unblock, or ‘unfreeze’ your Orbiter Card at any time by logging in to your account and completing the action through the card management area.
                  5.6 Should we block your Orbiter Card and/or account, no payments will be made from your card and/or account until the card and/or account has been unblocked. We accept no responsibility for payments that were not paid into or out of your card and/or account as a result of a block on your Orbiter Card and/or account.
                  5.7 You must not make a payment that would leave your account in a negative balance.
                  5.8 There are some rare occasions where your Orbiter Account balance may be a negative amount. It is your responsibility to pay funds into your Orbiter Account immediately to cover any negative balance on your account. If you persistently have a negative balance or fail to pay in to cover a negative balance immediately we reserve the right to close your Orbiter Account.
                  5.9 If a payment into your Orbiter Account is automatically recalled as a duplicate transaction or a transaction sent in error, the payment will be debited from your Orbiter Account. Should a recall of funds mean that your account is in negative balance it is your responsibility to ensure that funds are paid into your Orbiter Account immediately to cover the negative balance.
                  5.10 We reserve the right to engage the services of a third-party debt collection agency to assist in the collection of any negative balance(s) on your account and we may take legal action to recover any outstanding amounts. This may have an adverse impact on your credit rating.
                  6 Fees and Limits
                  6.1 The fees and limits relating to your account can be found on our website, or the app, either in the Profile section of your logged-in account, or Orbiter.one.
                  6.2 If you do not have sufficient funds in your account to cover the monthly fee, the fee will be deducted from your account the next time funds are paid into your Orbiter Account.
                  6.3 If you have partial funds in your account to cover your monthly fee, the partial amount will be debited from your Orbiter Account and the remaining owed on your monthly fee(s) will be debited from your account the next time funds are paid into your Orbiter Account.
                  6.4 If we are unable to take your monthly fee for one month, the next month we will attempt to take the monthly fee for both the month owed and the current month.
                  6.5 If we are unable to take your monthly fee for three consecutive months, your Orbiter Account will be closed.
                  6.6 The card activation fee you paid will be used for various compliance costs and card issuance expenses. Once the card is issued, the activation fee will not be refunded.
                  6.7 We will provide you, via the Website, with an annual statement of Fees which will set out all Fees incurred during the relevant period for services linked to your Orbiter Account.
                  7 Transactions
                  7.1 You must not use your Orbiter Card for:
                  7.1.1 Pre-authorised regular payments;
                  7.1.2 Transactions for cash (other than cash withdrawal and instore cashback with participating retailers) including, for example, cash from a bank, money orders, travellers’ cheques, foreign exchange, or bureau de change, or any illegal purposes;
                  7.2 Your card cannot be used in situations where it is not possible for the supplier to obtain online authorisation that you have sufficient balance for the transaction. For example some transactions on trains, ships, and some in-flight purchases.
                  7.3 Any use of your account, card, card number or PIN constitutes your authorisation and consent to a transaction. You provide authorisation when you input your PIN in person when paying for something, by providing your card to make a transaction or a number of transactions (may be referred to as a continuous payment authority), when you input your card number during an online checkout process or when you set up a standing order, payment or Direct Debit to pay a person or organisation.
                  7.4 Where you have provided a person or organisation with your consent to a recurring payment or continuous payment authority, you can contact us to cancel this. You must also contact the person or organisation you are paying. You will still be responsible for any money you owe. You must contact us before 2 pm at the latest on the working day before the payment is due. If you do not cancel the payment by the deadline specified above, we cannot accept responsibility for any payments that are subsequently debited to your card and you will need to contact the person or organisation you are paying to cancel the payment.
                  7.5 We may refuse a transaction or suspend or terminate the right to pay into your account. We may do this if:
                  7.5.1 A transaction might take you over your available funds in the account; or
                  7.5.2 A transaction might take you over any of your account or card limits; or
                  7.5.3 We reasonably believe that we need to do so to keep to the rules of the payment system under which your card is issued; or
                  7.5.4 We reasonably believe that there are needs to do so to comply with any law or as a matter of good practice.
                  7.6 If you notice a payment out of your account that you did not authorise, you should contact us and we may require additional information from you to aid any investigation into an unauthorised transaction on your account.
                  7.7 If we find that a payment transaction was not authorised by you and you have provided sufficient information to us, we will refund the amount of the unauthorised transaction to you on the same working day if we are notified before 4 pm, or by 10 am on the following working day if we are notified of an unauthorised transaction after 4 pm. Where applicable, we will refund any fees that have been incurred as a result of the transaction taking place. These timescales do not apply if we have reasonable grounds to suspect fraud on your part.
                  7.8 You will be liable for:
                  7.8.1 All payments and any losses in respect of unauthorised transactions where you have acted fraudulently;
                  7.8.2 All payments and any losses if you intentionally or negligently failed to take reasonable steps to keep the security features of your card safe or have failed to comply with these terms and conditions.
                  7.9 We may debit your account with any amount refunded if we subsequently become aware that the payment was authorised by you.
                  7.10 If it is found that you have deliberately made a false claim that a payment was unauthorised we may report this to the relevant authorities.
                  8 Liability
                  8.1 You must always make sure that you keep your Orbiter Card and your personal security details secure. You should ensure that you:
                  8.1.1 Do not allow anyone else to use your card;
                  8.1.2 Do not reveal your PIN and never write down your password(s), PIN or any security information you have given us unless you do this in a way that would make it impossible for anyone else to recognise any of that information;
                  8.1.3 Only release the card, card number or PIN to make (or try to make) a transaction.
                  8.2 If your card is lost or stolen or someone else finds out the PIN, or if you think your card, card number or PIN may be misused, you must log in to the website or app and notify us that your card is lost/stolen using the card management area.
                  8.3 You may not be liable for any use of the card, card number or PIN by another person who does not have your permission to use it or if it is lost, stolen or destroyed, unless:
                  8.3.1 You agreed to that person having your card, card number or PIN, or through gross negligence or carelessness, failed to comply with condition 7.1, in which case you may be liable for any use that occurs before you tell us in accordance with these terms and conditions; or
                  8.3.2 You acted fraudulently, in which case, to the extent permitted by law, you may be liable for misuse of the card, card number or PIN.
                  8.4 If your card is used without your permission ,is lost or stolen, or if you think the card may be misused, we may disclose to law enforcement agencies any information which we reasonably believe may be relevant.
                  8.5 We will not be liable for:
                  8.5.1 Any abnormal or unforeseeable circumstances outside our reasonable control (for example, a failure of computer systems which happens for reasons outside our reasonable control or any industrial action which happens for reasons outside our reasonable control) if this prevents us from providing our usual service;
                  8.5.2 Any person refusing to accept payment;
                  8.5.3 Any cash dispenser failing to issue cash;
                  8.5.4 The quality, safety, legality, or any other aspect of any goods or services purchased with the Orbiter Account or Orbiter Card; or
                  8.5.5 The way in which you are told about any refusal or delay.
                  9 Changes to these Terms and Conditions
                  9.1 We may change any of these terms and conditions, including changes to fees and charges, or to introduce new terms. We will give 60 days’ prior notice for material changes to the terms and conditions; should the change have no material effect to you or be to your benefit, changes to these terms and conditions will become effective immediately. We will notify you of changes to these terms and conditions by ways described on our website.
                  9.2 If we change these terms and conditions, the new terms and conditions will be available at Orbiter.one from the date we notify you of the change.
                  9.3 You will be deemed to have accepted any change to these terms and conditions unless you notify us of any objection before the proposed date of the change. Between receipt of the notice and the proposed date of the change, if you notify us that you do not accept the change, this agreement will terminate immediately and, subject to condition 10, you can redeem your total balance at that time without charge.
                  10 Closure Rights
                  10.1 If you change your mind about having the account and card, you can close it within 14 days of the date on which you receive confirmation of your application being approved by contacting us in ways described on our website. You will not be charged for closing your account and cancelling your card during this period. We will refund to you any balance remaining on the card.
                  10.2 You can also close your account and cancel your Orbiter Card any time after the 14 days by contacting us; you will not be charged for closing your Orbiter Account or cancelling your card.
                  10.3 You agree that by requesting for your account to be closed we will commence the closure process. This includes:
                  10.3.1 Cancelling payments due to leave your Orbiter Account
                  10.3.2 Rejecting incoming payments to your Orbiter Account
                  10.4 Closing your account does not guarantee that payments that are being processed will not leave your Orbiter Account. We do not accept responsibility for payments that are made from your Orbiter Account following a closure request.
                  10.5 You will not be entitled to a refund of money you have already spent on transactions authorised or pending or any fees for use of the Orbiter Card or Orbiter Account before the account is closed or the card expires.
                  11 Ending this agreement
                  11.1 We may terminate this agreement at any time. We will give you 60 days’ prior notice to termination of the agreement unless it is an exceptional circumstance, which includes abuse to staff and material breaches to these terms and conditions.
                  11.2 Reasons for ending the agreement may include:
                  11.2.1 If this agreement or your Orbiter Card expires;
                  11.2.2 If you break an important part of this agreement, or repeatedly break the agreement and fail to resolve the matter in a timely manner;
                  11.2.3 If you act in a manner that is threatening or abusive to our staff, or any of our representatives;
                  11.2.4 If you fail to pay fees or charges that you have incurred or fail to pay back any negative balance on your card; or
                  11.2.5 If your account has not had any transactions on it for a consecutive 90 day period. Please note that any fees for non-chargeable transactions do not count as a transaction in this instance.
                  11.3 We may also close your account and cancel your card immediately if we suspect fraud or misuse of your card or account or have any other security concerns, or need to do so to comply with the law.
                  11.4 We may close your account if you use it as a business account.
                  11.5 Once the termination of your account commences, all payment mandates out of your account will be cancelled. Any payments into your account will be returned to the sender. If a payment is in the process of being paid out when the closure process commences there is a possibility that the payment may still go through. It is your responsibility to ensure that you have made alternative arrangements for payments in to and from your Orbiter Account. We do not accept liability for any payments made or missed as a result of the account termination process commencing.
                  11.6 If you do not redeem your full balance within 6 years of your card’s expiry date, this agreement terminates. If this happens, you will not be entitled to reclaim any funds that were held in your Orbiter Account upon termination.
                  11.7 If you waive any remaining balance in your account upon closure the funds will be transferred into an account held by us and your account will be closed.
                  12 General
                  12.1 By entering into this agreement you agree that we may use your information in accordance with our Privacy Notice
                  12.2 We may monitor and/or record telephone calls between you and us or service providers.
                  12.3 We may record all communications you have with us including social media interactions.
                  12.4 You must provide us with an email and postal address and mobile phone number, and let us know of any changes to this information. You must advise us immediately of any changes to the details we hold for you; it is your responsibility to ensure that your details are up to date at all times.
                  12.5 We may transfer our rights or obligations under this agreement or arrange for any other person to carry out our rights or obligations under this agreement. You may not transfer any of your rights or obligations under this agreement.
                  12.6 We can delay enforcing our rights under this agreement without losing them.
                  12.7 If we cannot enforce any paragraph, condition or part of a paragraph or condition under this agreement, it will not affect any of the other paragraphs, conditions or the other part of the paragraph or condition in this agreement.
                  12.8 This agreement is governed by the law of England and Wales. The language of this agreement is English and all notices and information given under this agreement will be in English.
                  13 Payment services information
                  13.1 This condition 15 only applies if the supplier’s bank is located within the qualifying area and the payment services being carried out are transacted in sterling or euro.
                  13.2 We will ensure that any transaction you make is credited to the supplier’s bank, or that returned funds following redemption or cancellation are credited to your bank by the end of the business day following the day on which the transaction order is received, with the following exceptions:
                  Transactions that are not:
                  13.2.1 Executed wholly within the qualifying area in euro under a payment scheme which operates across the qualifying area;
                  13.2.2 Executed wholly under a payment scheme which operates across the qualifying area and executed wholly in the United Kingdom in sterling; or
                  13.2.3 Executed wholly under a payment scheme which operates across the qualifying area and involving only one currency conversion between the euro and sterling, provided that—

                  13.2.3.1 the currency conversion is carried out in the United Kingdom; and
                  13.2.3.2 in the case of cross-border payment transactions, the cross-border transfer takes place in euro.
                  will be credited by the end of the fourth day following the day on which the transaction or order is received.
                  13.3 If you make a payment directly from your account to another person within the qualifying area and it arrives later than it should have, you can ask us to contact the receiving bank to ask that they treat the payment as if it was made on time.
                  13.4 In the unlikely event that you spend on your card without knowing the exact amount at the time of authorising the payment (for example, at a hotel), we won’t knowingly block any additional funds in your account beyond the amount requested from the merchant. As soon as we can confirm the exact amount you need to pay, we’ll release any additional blocked funds straight away.
                  13.5 If you use your card or provide your card details to a supplier to make a transaction before you know the amount that is going to be charged to your card, then you may be entitled to request a refund if the amount is greater than expected, provided that you tell us within eight weeks of the date the transaction is deducted from your balance. You will not be entitled to a refund if you have been told by us, or the supplier, of the amount of that transaction at least four weeks before the transaction is due to be deducted from your balance, and you consented to the transaction.
                  13.6 On receipt of such a request under condition 15.5, we may require you to provide us with information to ascertain whether the conditions in condition 15.5 have been met. Within 10 days of receiving a request from you under condition 15.5 or on receiving any additional information required under this paragraph, we will provide a refund or justify why we are refusing the request.
                  13.7 We are liable for the correct execution of the transaction unless we can prove that the transaction was received by the supplier’s bank, in which case the supplier’s bank is liable to the supplier. You may request that we make immediate efforts to trace an incorrectly executed transaction and notify you of the outcome.
                  13.8 When a supplier initiates a transaction it is the supplier’s bank that is liable for the correct transmission of the relevant details to us. If the supplier’s bank can prove that it is not responsible for a transaction that has failed or has been incorrectly executed, we will be responsible for you.
                  13.9 If we are responsible for an incorrect amount of a transaction being deducted from your balance, we will correct the error. If we are responsible for a transaction being deducted from your balance which you did not authorise, we will refund the amount of the transaction to your balance and treat the transaction as if it had never occurred. You must inform us of any unauthorised or incorrect transaction as soon as possible and in any event no later than 13 months after the debit date. If you do not do so, we may not be liable.
                  13.10 We are not liable if you make a payment to the wrong recipient. In such a case, we will make reasonable efforts to recover the funds involved. If you let us know of a payment you’ve paid to the wrong person by mistake over 13 months later, we’ll do our best to trace the payment, but we may charge you a reasonable fee to do this.
                  14 Complaints
                  14.1 If you would like to make a complaint or contact us for any other reason connected to these terms and conditions please contact us in ways described on the website.
                  15 Contacting us
                  15.1 You can contact us in the ways set out on our website.
                  16 How we’ll contact you
                  16.1 We’ll contact you by email, secure message or by telephone.
                  17 Fee Information Documents
                  17.1 . We will provide you with a Fee information document, prior to you entering into this Agreement, which will set out all associated Fees of using your Orbiter Account. This Fee information document (as updated from time to time) will be available at any time from the Website, throughout the duration of this Agreement. This will be provided free of charge. You may also request us to provide this to you on paper.`,
      content2: `Orbiter Privacy policy
                  Orbiter (referred to as ' Orbiter ', 'us', 'our', 'we') which is an e-money product dedicated to facilitating transactions and the provision of related services.
                  By browsing, visiting or using Orbiter, our APP and exchange service (collectively, service), you ('user') shall be deemed to have understood and agreed to all of the terms and conditions of this policy. Please carefully review and consider the terms of this policy, if you do not agree to the policy, you must immediately stop the use of the Services.
                  We may at any time amend this policy, include but not limited to any policy or instruction on the platform. We shall notify you these changes either through marking the amended versions with latest release date on the top of the policy, or any other method we decide that is appropriate. Any changes or modifications will take effective immediately upon posting on this website and applies to all current and subsequent use or services.
                  If you continue to use any of the Services you shall be deemed to have agreed to the revised terms of this policy. If you do not agree to the policy, you must immediately stop the use of the Services. You are advised to review the policy regularly to ensure that you understand the terms and conditions.
                  For the purposes of applicable data protection law (in particular, the General Data Protection Regulation (EU) 2016/679 (the "GDPR")), the entity referred to above is the "data controller" of your personal data.
                  Personal Data We collect
                  We may collect and process the following personal data:
                  • Information you give us:
                  • When you create an account on our site in order to become a user, we may process your personal data - including your name, address, e-mail address, phone number, vehicle registration number, payment method, debit card information.
                  • Information we collect about you: With regard to each of your visits to our site we may automatically collect the following information:
                  • technical information, including the Internet protocol (IP) address used to connect your computer to the Internet, your login information, browser type and version, time zone setting, browser plug-in types and versions, operating system and platform; and
                  • information about your visit; products, services or issues you viewed or searched for; page response times, download errors, length of visits to certain pages, page interaction information (such as scrolling, clicks, and mouse-overs), and methods used to browse away from the site.
                  • Information we receive from other sources:
                  • We may also receive information about you when our payment service provider settles a payment on your behalf and /or from your bank in the event there is a failed payment.
                  • Information about other people: If you provide information to us about any person other than yourself, such as your relatives, next of kin, your advisers or your suppliers, you must ensure that they understand how their information will be used, and that they have given their permission for you to disclose it to us and for you to allow us, and our outsourced service providers, to use it.
                  General Use and Legal Basis
                  We use your personal data:
                  1. To measure the adequate performance of our contract with you, for:
                  • Managing such contractual relationship between you and us; and
                  • Enabling you to access and use our site,
                  2. Where this is necessary for purposes which are in our legitimate interests. These interests are:
                  • Facilitating the creation of, and securing, your account on our network; and
                  • Improving the quality of experience when you interact with our services.
                  3. For purposes which are required by law:
                  • Responding to requests by government or law enforcement authorities conducting an investigation.
                  Disclosure of Your Personal Data
                  We can share your personal data with our subsidiaries and/ or affiliates.
                  We can also share your personal data with trusted third parties including:
                  • Providers that assist us with our anti-money laundering, sanctions, terrorist financing obligations and other financial services.
                  • Third party card processing and merchant acquiring companies that will process your debit card payments for us.
                  • Analytics and search engine providers that assist us in the improvement and optimisation of our site.
                  • Debt collection companies we have appointed where you fail to make a payment to us despite several notifications to you.
                  International Transfers
                  As an international organisation, authorised personnel may access your personal information in any country in which we operate. Therefore, it may be necessary to transfer your details to members of our group located in countries that may not offer equivalent data protection or privacy laws to those in the UK or the EU.
                  Regardless of where your personal information is transferred, we shall ensure that your personal information is safe and shall take all steps reasonably necessary to put in place appropriate safeguards to ensure that your personal information is treated securely and in accordance with this statement and applicable law.
                  We do not provide your information for marketing purposes or to marketing companies.
                  Moreover, we can disclose your personal data to third parties:
                  • If we sell or buy any business or assets, in which case we can disclose your personal data to the prospective seller or buyer of such business or assets;
                  • If we, our business, or our assets are acquired by a third party, in which case personal data held by us about our users, suppliers, or customers will be one of the transferred assets; and
                  • If we are under a duty to disclose or share your personal data in order to comply with any legal obligation, or in order to enforce or apply our terms and conditions Orbiter Privacy policy
                  Orbiter (referred to as ' Orbiter ', 'us', 'our', 'we') which is an e-money product dedicated to facilitating transactions and the provision of related services.
                  By browsing, visiting or using Orbiter, our APP and exchange service (collectively, service), you ('user') shall be deemed to have understood and agreed to all of the terms and conditions of this policy. Please carefully review and consider the terms of this policy, if you do not agree to the policy, you must immediately stop the use of the Services.
                  We may at any time amend this policy, include but not limited to any policy or instruction on the platform. We shall notify you these changes either through marking the amended versions with latest release date on the top of the policy, or any other method we decide that is appropriate. Any changes or modifications will take effective immediately upon posting on this website and applies to all current and subsequent use or services.
                  If you continue to use any of the Services you shall be deemed to have agreed to the revised terms of this policy. If you do not agree to the policy, you must immediately stop the use of the Services. You are advised to review the policy regularly to ensure that you understand the terms and conditions.
                  For the purposes of applicable data protection law (in particular, the General Data Protection Regulation (EU) 2016/679 (the "GDPR")), the entity referred to above is the "data controller" of your personal data.
                  Personal Data We collect
                  We may collect and process the following personal data:
                  • Information you give us:
                  • When you create an account on our site in order to become a user, we may process your personal data - including your name, address, e-mail address, phone number, vehicle registration number, payment method, debit card information.
                  • Information we collect about you: With regard to each of your visits to our site we may automatically collect the following information:
                  • technical information, including the Internet protocol (IP) address used to connect your computer to the Internet, your login information, browser type and version, time zone setting, browser plug-in types and versions, operating system and platform; and
                  • information about your visit; products, services or issues you viewed or searched for; page response times, download errors, length of visits to certain pages, page interaction information (such as scrolling, clicks, and mouse-overs), and methods used to browse away from the site.
                  • Information we receive from other sources:
                  • We may also receive information about you when our payment service provider settles a payment on your behalf and /or from your bank in the event there is a failed payment.
                  • Information about other people: If you provide information to us about any person other than yourself, such as your relatives, next of kin, your advisers or your suppliers, you must ensure that they understand how their information will be used, and that they have given their permission for you to disclose it to us and for you to allow us, and our outsourced service providers, to use it.
                  General Use and Legal Basis
                  We use your personal data:
                  1. To measure the adequate performance of our contract with you, for:
                  • Managing such contractual relationship between you and us; and
                  • Enabling you to access and use our site,
                  2. Where this is necessary for purposes which are in our legitimate interests. These interests are:
                  • Facilitating the creation of, and securing, your account on our network; and
                  • Improving the quality of experience when you interact with our services.
                  3. For purposes which are required by law:
                  • Responding to requests by government or law enforcement authorities conducting an investigation.
                  Disclosure of Your Personal Data
                  We can share your personal data with our subsidiaries and/ or affiliates.
                  We can also share your personal data with trusted third parties including:
                  • Providers that assist us with our anti-money laundering, sanctions, terrorist financing obligations and other financial services.
                  • Third party card processing and merchant acquiring companies that will process your debit card payments for us.
                  • Analytics and search engine providers that assist us in the improvement and optimisation of our site.
                  • Debt collection companies we have appointed where you fail to make a payment to us despite several notifications to you.
                  International Transfers
                  As an international organisation, authorised personnel may access your personal information in any country in which we operate. Therefore, it may be necessary to transfer your details to members of our group located in countries that may not offer equivalent data protection or privacy laws to those in the UK or the EU.
                  Regardless of where your personal information is transferred, we shall ensure that your personal information is safe and shall take all steps reasonably necessary to put in place appropriate safeguards to ensure that your personal information is treated securely and in accordance with this statement and applicable law.
                  We do not provide your information for marketing purposes or to marketing companies.
                  Moreover, we can disclose your personal data to third parties:
                  • If we sell or buy any business or assets, in which case we can disclose your personal data to the prospective seller or buyer of such business or assets;
                  • If we, our business, or our assets are acquired by a third party, in which case personal data held by us about our users, suppliers, or customers will be one of the transferred assets; and
                  • If we are under a duty to disclose or share your personal data in order to comply with any legal obligation, or in order to enforce or apply our terms and conditions https://www.Orbiter.one/en-us/article/detail and other agreements; or if we reasonably consider this necessary; or to protect the rights, property, or safety of us, our users, our customers, or others.
                  Where We Store Your Personal Data and How We Protect it
                  We take reasonable steps to protect your personal data from loss or destruction. Where you have a username or password (or other identification information) which enables you to access certain services or parts of our site, you are responsible for keeping this password confidential. We ask you not to share a password with anyone.
                  Unfortunately, the transmission of information via the internet is not completely secure. Although we will do our best to protect your personal data, we cannot guarantee the security of your personal data transmitted to our site; any transmission is at your own risk. Once we have received your personal data, we will use strict procedures and security features to try to prevent unauthorised access.
                  Your Rights
                  You have various rights with respect to our use of your personal data:
                  • Access: You have the right to request a copy of the personal data that we hold about you. Please note that there are exceptions to this right, so that access may be denied if, for example, making the information available to you would reveal personal data about another person, or if we are legally prevented from disclosing such information. You are entitled to see the personal data held about you. If you wish to do this, please contact us using the contact details provided below.
                  • Accuracy: We aim to keep your personal data accurate, current, and complete. We encourage you to contact us using the contact details provided below to let us know if any of your personal data is not accurate or changes, so that we can keep your personal data up-to-date. You can also review and correct/ update some of your personal data by logging-in to your account on our site.
                  • Objecting: In certain circumstances, you also have the right to object to processing of your personal data and to ask us to block, erase and restrict your personal data. If you would like us to stop using your personal data, please contact us using the contact details provided below.
                  • Porting: You have the right to request that some of your personal data is provided to you, or to another data controller, in a commonly used, machine-readable format.
                  • Erasure: You have the right to erase your personal data when the personal data are no longer necessary for the purposes for which they were collected, or when, among other cases, your personal data have been unlawfully processed.
                  • Complaints: If you believe that your data protection rights may have been breached, you have the right to lodge a complaint the applicable supervisory authority or to seek a remedy through the courts.
                  You can exercise any of the abovementioned rights by emailing us at: support@Orbiter.one.
                  How Long We Keep Your Personal Data
                  We will retain your personal data, whether or not your account is active, for as long as we believe it necessary or desirable to fulfil our business purposes or to comply with applicable law, audit requirements, regulatory requests or orders from competent courts.
                  Questions, comments and requests regarding this Policy are welcomed.
                  and other agreements; or if we reasonably consider this necessary; or to protect the rights, property, or safety of us, our users, our customers, or others.
                  Where We Store Your Personal Data and How We Protect it
                  We take reasonable steps to protect your personal data from loss or destruction. Where you have a username or password (or other identification information) which enables you to access certain services or parts of our site, you are responsible for keeping this password confidential. We ask you not to share a password with anyone.
                  Unfortunately, the transmission of information via the internet is not completely secure. Although we will do our best to protect your personal data, we cannot guarantee the security of your personal data transmitted to our site; any transmission is at your own risk. Once we have received your personal data, we will use strict procedures and security features to try to prevent unauthorised access.
                  Your Rights
                  You have various rights with respect to our use of your personal data:
                  • Access: You have the right to request a copy of the personal data that we hold about you. Please note that there are exceptions to this right, so that access may be denied if, for example, making the information available to you would reveal personal data about another person, or if we are legally prevented from disclosing such information. You are entitled to see the personal data held about you. If you wish to do this, please contact us using the contact details provided below.
                  • Accuracy: We aim to keep your personal data accurate, current, and complete. We encourage you to contact us using the contact details provided below to let us know if any of your personal data is not accurate or changes, so that we can keep your personal data up-to-date. You can also review and correct/ update some of your personal data by logging-in to your account on our site.
                  • Objecting: In certain circumstances, you also have the right to object to processing of your personal data and to ask us to block, erase and restrict your personal data. If you would like us to stop using your personal data, please contact us using the contact details provided below.
                  • Porting: You have the right to request that some of your personal data is provided to you, or to another data controller, in a commonly used, machine-readable format.
                  • Erasure: You have the right to erase your personal data when the personal data are no longer necessary for the purposes for which they were collected, or when, among other cases, your personal data have been unlawfully processed.
                  • Complaints: If you believe that your data protection rights may have been breached, you have the right to lodge a complaint the applicable supervisory authority or to seek a remedy through the courts.
                  You can exercise any of the abovementioned rights by emailing us at: support@Orbiter.one.
                  How Long We Keep Your Personal Data
                  We will retain your personal data, whether or not your account is active, for as long as we believe it necessary or desirable to fulfil our business purposes or to comply with applicable law, audit requirements, regulatory requests or orders from competent courts.
                  Questions, comments and requests regarding this Policy are welcomed.`,
      content3: `Orbiter Cookie Policy
                  Orbiter (referred to as ' Orbiter', 'us', 'our', 'we') which is an e-money product dedicated to facilitating transactions and the provision of related services.
                  By browsing, visiting or using Orbiter, our APP and exchange service (collectively, service), you ('user') shall be deemed to have understood and agreed to all of the terms and conditions of this policy. Please carefully review and consider the terms of this policy, if you do not agree to the policy, you must immediately stop the use of the Services.
                  We may at any time amend this policy, include but not limited to any policy or instruction on the platform. We shall notify you these changes either through marking the amended versions with latest release date on the top of the policy, or any other method we decide that is appropriate. Any changes or modifications will take effective immediately upon posting on this website and applies to all current and subsequent use or services.
                  If you continue to use any of the Services you shall be deemed to have agreed to the revised terms of this policy. If you do not agree to the policy, you must immediately stop the use of the Services. You are advised to review the policy regularly to ensure that you understand the terms and conditions.
                  What are cookies?
                  A cookie is a file containing an identifier (a string of letters and numbers) that is sent by a web server to a web browser and is stored by the browser. The identifier is then sent back to the server each time the browser requests a page from the server.
                  We may collect information about your computer, including your IP address, operating system and browser type, for system administration and to report aggregated information to our advertisers. This is statistical data about our users' browsing actions and patterns, and does not identify any individual. We may collect information about your use of our website, such as pages visited, links clicked, non-sensitive text entered, and mouse movements.
                  What purpose do we use cookies for?
                  Our purpose in collecting this information is to better understand how our visitors use our website and to identify any usability problems, so that we may make the necessary improvements to enhance our visitors’ experience in the future. When we collect this information, your identity will remain anonymous and we do not use this information to identify you.
                  How do we use cookies?
                  We may obtain information about your general internet usage by using a cookie file which is stored on the hard drive of your computer. Cookies contain information that is transferred to your computer's hard drive.
                  They help us to improve the Website and to deliver a better and more personalised service. They enable us:
                  • to estimate our audience size and usage pattern;
                  • to store information about your preferences, and so allow us to customise our site according to your individual interests;
                  • to speed up your searches;
                  • to recognise you when you return to our site.
                  We use Google Analytics to analyse the use of our website. Google Analytics gathers information about website use by means of cookies. The information gathered relating to our website is used to create reports about the use of our website. Google's privacy policy is available at: https://www.google.com/policies/privacy/.

                  How can I control or delete cookies?
                  Most web browsers offer users controls, to give you the option to delete or disable cookies. You can usually find out how to do so by referring to the ‘Help’ option on the menu bar of your browser, or by visiting the browser developer's website. This will usually tell you how to prevent your browser from accepting new cookies; notify you when you receive new cookies; and disable cookies altogether. Please note that disabling cookies will stop you accessing private areas of the website. Blocking all cookies will have a negative impact upon the usability of many websites. If you block cookies, you will not be able to use all the features on our website.`,
      content4: `Orbiter AML


                    Anti-Money Laundering and Counter-Terrorist Financing Statement

                    Orbiter (referred to as 'Orbiter', 'us', 'our', 'we') which is an e-money product dedicated to facilitating transactions and the provision of related services.

                    By browsing, visiting or using Orbiter, our APP and exchange service (collectively,
                    service), you ('user') shall be deemed to have understood and agreed to all of the terms and
                    conditions of this statement. Please carefully review and consider the terms of this
                    statement, if you do not agree to the statement, you must immediately stop the use of the
                    Services.

                    We may at any time amend this statement, include but not limited to any policy or instruction on the platform. We shall notify you these changes either through marking the amended versions with latest release date on the top of the statement, or any other method we decide that is appropriate. Any changes or modifications will take effective immediately upon posting on this website and applies to all current and subsequent use or services.
                    If you continue to use any of the Services you shall be deemed to have agreed to the revised terms of this statement. If you do not agree to the statement, you must immediately stop the use of the Services. You are advised to review the statement regularly to ensure that you understand the terms and conditions.

                    1. This statement is a summary of the policies and procedures which we have implemented to reduce the risk of money laundering and terrorist financing. This statement only covers the use of the Orbiter and other policies may apply for customers receiving separate services from us or our partners (such as the use of a debit card).

                    2. Due to new UK anti-money laundering legislation which is due to enter into force on 10 January 2020, Orbiter will become subject to the UK anti-money laundering regime. As a matter of best practice, we have decided to comply with these requirements before this date. We are already subject to a number of other laws in the UK, including the Proceeds of Crime Act 2002 and the Terrorism Act 2000.

                    What is money laundering/terrorist financing?

                    1. Money Laundering is the process whereby criminals conceal the actual ownership and origin of the proceeds of criminal activities. The phrase ‘money laundering’ can cover all methods used to obscure the identity of illegally obtained assets so that they can be used for legitimate purposes.
                    2. Terrorist financing is the use of financial systems and infrastructure to fund terrorism.


                    Customer Due Diligence
                    3. We will seek from customers such information as is necessary in order to verify their identity in accordance with the requirements which exist under the UK's anti-money laundering regime. We may use third party sources to verify information about customers or may require customers to produce copies of documents which evidence their identity.

                    4. Customer due diligence will be conducted on a risk-sensitive basis, with customers posing the highest risk being required to provide more information than customers who pose a low risk. We have in place policies and procedures to recognise when there is a higher risk of money laundering. Customers who are also considered politically exposed persons (PEPs) will be identified and be subject to a more stringent verification procedure.

                    5. If we are unable to verify a customer's identity, we will not enter into a business relationship with that customer or allow that customer to make a transaction on the Orbiter. If we consider that a customer poses a sufficiently high risk of money laundering then we will not enter into a business relationship with that customer.

                    6. Evidence of a customer's identity will be retained by us for at least 5 years from the date that the relationship with the customer comes to an end. All data collected by us in discharging its anti-money laundering obligations will be processed in accordance with our privacy policy which can be found on the website.

                    Transaction Monitoring
                    7. Once a customer's identity has been verified, we have ongoing obligations to monitor transactions which occur on the Orbiter to determine whether a customer's transactions are suspicious.

                    8. We have in place policies and procedures which allow us to recognise which transactions are suspicious and merit further investigation.
                    Organisational Procedures
                    9. We have appointed a Money Laundering Reporting Officer (MLRO) who will be responsible for overseeing our anti-money laundering function, ensuring that all disclosures which are required by law are made (including any suspicious activity reports) and reporting to the board of directors with an annual report on the compliance with the money laundering regime.

                    10. We train all relevant staff so that they are familiar with the process for verifying the identity of customers and to recognise the signs that there may be an increased risk of money laundering and how to deal with that increased level of risk.

                    11. The MLRO and our board of directors will regularly review the policies and procedures to ensure that they remain effective in preventing the use of the Orbiter for money laundering and terrorist financing.
                    Sanctions Regime
                    12. In addition to complying with the UK's anti-money laundering regime, we follow policies and procedures to comply with the UK's sanctions regimes.

                    13. Checks are undertaken to ensure that potential customers are not listed on any sanctions list maintained by the UK Government. We will not allow any person who is on a sanctions list to use the Orbiter to make a transaction.`,
    };
  },

  mounted() {
    switch (this.$route.query.id) {
      case "1":
        this.content = this.content1;
        this.name = "orbiterwallet注册协议";
        break;
      case "2":
        this.content = this.content2;
        this.name = "隐私政策";
        break;
      case "3":
        this.content = this.content3;
        this.name = "Cookie政策";
        break;
      case "4":
        this.name = "AML政策";
        this.content = this.content4;
        break;
    }
  },

  methods: {
    goBack() {
      this.$router.push("/login/agreement");
    },
  },
};
</script>

<style lang="less" scoped>
.res-login-header {
  width: 471px;
  height: 44px;
  line-height: 44px;
  position: absolute;
  top: 0;
  left: 0;
  z-index: 1;
  background: transparent;
  text-align: center;
  font-weight: 700;
  font-size: 16px;
  color: #000;
  cursor: pointer;

  .type {
    position: absolute;
    top: 12px;
    left: 16px;
  }
}
.detail-content {
  font-size: 14px;
  color: #000;
  overflow: auto;
}
</style>
