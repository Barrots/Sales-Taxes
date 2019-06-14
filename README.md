# Sales Taxes Exercise [![Build Status](https://travis-ci.org/Barrots/Sales-Taxes.svg?branch=master)](https://travis-ci.org/Barrots/Sales-Taxes) [![codecov](https://codecov.io/gh/Barrots/Sales-Taxes/branch/master/graph/badge.svg)](https://codecov.io/gh/Barrots/Sales-Taxes/branch/master) 

This application prints out the receipt details for shopping baskets based on the goods inside and the tax rules previously decided.

###Tax Rules:

Basic sales tax is applicable at a rate of 10% on all goods, except books, food, and medical
products that are exempt. Import duty is an additional sales tax applicable on all imported goods
at a rate of 5%, with no exemptions.
When I purchase items I receive a receipt which lists the name of all the items and their price
(including tax), finishing with the total cost of the items, and the total amounts of sales taxes
paid. The rounding rules for sales tax are that for a tax rate of n%, a shelf price of p contains
(np/100 rounded up to the nearest 0.05) amount of sales tax.

###Generated Output:
For the sake of testing and showing the generated outputs I decided to print the results in Standard Output knowing that in a normal project that should not happen.


####Feel free to start the Receipt Generation in the StarterApplicationTest
