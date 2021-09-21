Project 2 by engeto academy
--

Main goal
--

Input file here: https://euvatrates.com/rates.json

Main goal is to mapped input json file to object and use basic operations (search implementation, save states to file, throw out top three states by vat rate).


Parts
--

First request:

Call API by HTTP in CallApiByHttp class (using httpClient, ...).

Second request:

Map json to object using ObjectMapper (every state is saved in new object, then saved in ArrayList + Hashmap <State symbol, State>)

Third request:

Code basic operations. As first a I sorted whole arraylist using sort method located in StateList. Then throw out first three max rate states + min rate states, save to file and lastly while loop function in search implementation by state symbols.
