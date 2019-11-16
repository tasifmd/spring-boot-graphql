# spring-boot-graphql

Get All User
--------------------
request --> { allUser { userId userName userEmail userMobile addresses { addressId addressLine1 addressLine2 
				addressType district state zipCode } } }

Get Single User
---------------------
request -->
{ user( userId: ID) { userId userName userEmail userMobile addresses{ addressId addressLine1 addressLine2 
				addressType district state zipCode } } }
				
Get All Address
---------------------
request -->
{ allAddress { addressId addressLine1 addressLine2 addressType district state zipCode } }

Get Single Address
---------------------
request -->
{ address(addressId: ID){ addressId addressLine1 addressLine2 addressType district state zipCode } }