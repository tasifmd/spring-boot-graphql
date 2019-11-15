# spring-boot-graphql

Get all user
--------------------
request -->
{
	allUser
	{
		userId 
		userName 
		userEmail 
		userMobile
		
	}
}

Get Single User
---------------------
request -->
{
	user( userId: ID)
	{
		userId 
		userName 
		userEmail 
		userMobile
		
	}
}
