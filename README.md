# MyTripApp
An Application to book cab nearest to current location.

Brief Overview:

1. On hitting below URL with details of customer, the app allocates a driver nearest to you using distance calculation formula by coordinates provided. 

URL : http://localhost:8050/trip/book
Request Body: {"name":"Seema","latitude":"32","longitude":"52"}
Response: {
    "name": "Chayan",
    "location": "kalyani nagar",
    "rating": null,
    "distance": null,
    "arrivingAt": null
}

2. Below URL provides details of ongoing trips.
http://localhost:8050/trip/ongoing/view

3.Below URL provides the details of drivers available
http://localhost:8050/driver/view

Scope of Improvement:
1.Handle Collision -- when both drivers are at equal distance-- look for ratings, distance travelled in the day, etc to allocate next trip
2.Allow Customer, Cab Driver and Admin to login into the application separately.
3.Write Junit Testcases for Service layer and Dao Layer. Can use mockito to mock the dao layer to prevent actual DB hits.
4.Define Error Codes at Technical and Business Exceptions so as to streamline the error reporting process from Support team to Dev Team.
5.Instead of creating an entry into the booking table at the time of booking, we can have bookings created when drivers login/complete a trip and then put the entry of a customer into customer column upon booking confirmation.
6. Show current location of the driver, calculate his approximate time of arrival and show to user.

