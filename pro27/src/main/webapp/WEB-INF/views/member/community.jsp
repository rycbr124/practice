<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style>
/*

All grid code is placed in a 'supports' rule (feature query) at the bottom of the CSS (Line 77). 
        
The 'supports' rule will only run if your browser supports CSS grid.

Flexbox is used as a fallback so that browsers which don't support grid will still recieve an identical layout.

*/

@import url(https://fonts.googleapis.com/css?family=Montserrat:500);

:root {
	/* Base font size */
	font-size: 10px;
}

*,
*::before,
*::after {
	box-sizing: border-box;
}

body {
	min-height: 100vh;
	background-color: #fafafa;
}

.container {
	max-width: 100rem;
	margin: 0 auto;
	padding: 0 2rem 2rem;
}

.heading {
	font-family: "Montserrat", Arial, sans-serif;
	font-size: 4rem;
	font-weight: 500;
	line-height: 1.5;
	text-align: center;
	padding: 3.5rem 0;
	color: #d2d2d2;
}

.heading span {
	display: block;
}

.gallery {
	display: flex;
	flex-wrap: wrap;
	/* Compensate for excess margin on outer gallery flex items */
	margin: -1rem -1rem;
}

.gallery-item {
	/* Minimum width of 24rem and grow to fit available space */
	flex: 1 0 24rem;
	/* Margin value should be half of grid-gap value as margins on flex items don't collapse */
	margin: 1rem;
	box-shadow: 0.3rem 0.4rem 0.4rem rgba(0, 0, 0, 0.4);
	overflow: hidden;
}

.gallery-image {
	display: block;
	width: 100%;
	height: 100%;
	object-fit: cover;
	transition: transform 400ms ease-out;
}

.gallery-image:hover {
	transform: scale(1.15);
}

/*

The following rule will only run if your browser supports CSS grid.

Remove or comment-out the code block below to see how the browser will fall-back to flexbox styling. 

*/

@supports (display: grid) {
	.gallery {
		display: grid;
		grid-template-columns: repeat(auto-fit, minmax(24rem, 1fr));
		grid-gap: 2rem;
	}

	.gallery,
	.gallery-item {
		margin: 0;
	}
}
</style>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="container">

	<h2 class="heading">COMMUNITY</h2>

	<div class="gallery">

		<div class="gallery-item">
			<img class="gallery-image" src="../image/duksu.jpg" alt="person writing in a notebook beside by an iPad, laptop, printed photos, spectacles, and a cup of coffee on a saucer">
		</div>

		<div class="gallery-item">
			<img class="gallery-image" src="../image/cultureDay.jpg" alt="sunset behind San Francisco city skyline">
		</div>

		<div class="gallery-item">
			<img class="gallery-image" src="../image/itaewon.jpg" alt="people holding umbrellas on a busy street at night lit by street lights and illuminated signs in Tokyo, Japan">
		</div>

		<div class="gallery-item">
			<img class="gallery-image" src="../image/olympic.jpg" alt="car interior from central back seat position showing driver and blurred view through windscreen of a busy road at night">
		</div>

		<div class="gallery-item">
			<img class="gallery-image" src="../image/hanRiver.jpg" alt="back view of woman wearing a backpack and beanie waiting to cross the road on a busy street at night in New York City, USA">
		</div>

		<div class="gallery-item">
			<img class="gallery-image" src="../image/삼청동.jpg" alt="man wearing a black jacket, white shirt, blue jeans, and brown boots, playing a white electric guitar while sitting on an amp">
		</div>
	</div>

</div>
</body>
</html>