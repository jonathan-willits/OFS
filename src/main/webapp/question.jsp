<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Welcome to OFS</title>
    <style>
        body {
            font-family: "poppins", sans-serif;
            margin: 20px;
            padding: 0;
            background-color: #f4f4f4;
        }
        .container {
            max-width: 600px;
            margin: auto;
            background: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
        }
        h2 {
            color: #333;
        }
        .form-group {
            margin-bottom: 20px;
        }
        .form-group label {
            display: inline-block;
            margin-bottom: 5px;
        }
        .form-group input[type="checkbox"] {
            display: inline-block;
            margin-right: 10px;
            vertical-align: middle; /* Align checkboxes vertically with labels */
        }
        .form-group input[type="text"],
        .form-group select {
            width: 100%;
            padding: 10px;
            border-radius: 4px;
            border: 1px solid #ddd;
            box-sizing: border-box;
        }
        .form-group input[type="submit"] {
            width: 100%;
            padding: 10px;
            border: none;
            border-radius: 4px;
            background-color: #5cb85c;
            color: white;
            cursor: pointer;
        }
        .form-group input[type="submit"]:hover {
            background-color: #4cae4c;
        }
    </style>
      <!-- Custom styles for this template -->
  <!-- <link href="css/style.css" rel="stylesheet" /> -->
</head>
<body>

<div class="container">
    <h2>Welcome to OFS</h2>
    <p>Please fill out the following questions to help us tailor our service to your needs.</p>
    <form action="/submit-your-preferences" method="POST">
        <div class="form-group">
            <label for="diet">Dietary Preferences:</label>
            <input type="checkbox" id="none" name="dietary_preferences[]" value="None">
            <label for="none">None</label>
            <input type="checkbox" id="vegetarian" name="dietary_preferences[]" value="Vegetarian">
            <label for="vegetarian">Vegetarian</label>
            <input type="checkbox" id="vegan" name="dietary_preferences[]" value="Vegan">
            <label for="vegan">Vegan</label>
            <input type="checkbox" id="gluten_free" name="dietary_preferences[]" value="Gluten-Free">
            <label for="gluten_free">Gluten-Free</label>
            <input type="checkbox" id="keto" name="dietary_preferences[]" value="Keto">
            <label for="keto">Keto</label>
            <input type="checkbox" id="halal" name="dietary_preferences[]" value="Halal">
            <label for="halal">Halal</label>
            <input type="checkbox" id="kosher" name="dietary_preferences[]" value="Kosher">
            <label for="kosher">Kosher</label>
            <input type="checkbox" id="Other" name="dietary_preferences[]" value="Other">
            <label for="Other">Other</label><br>
        </div>
        <div class="form-group">
            <label for="allergies">Allergies:</label>
            <input type="checkbox" id="allergy_none" name="allergies[]" value="None">
            <label for="allergy_none">None</label>
            <input type="checkbox" id="milk" name="allergies[]" value="Milk">
            <label for="milk">Milk</label>
            <input type="checkbox" id="fish" name="allergies[]" value="Fish">
            <label for="fish">Fish</label>
            <input type="checkbox" id="egg" name="allergies[]" value="Egg">
            <label for="egg">Egg</label>
            <input type="checkbox" id="nuts" name="allergies[]" value="Nuts">
            <label for="nuts">Nuts</label>
            <input type="checkbox" id="wheat" name="allergies[]" value="Wheat">
            <label for="wheat">Wheat</label>
            <input type="checkbox" id="shellfish" name="allergies[]" value="Shellfish">
            <label for="shellfish">Shellfish</label>
            <input type="checkbox" id="other_allergy" name="allergies[]" value="Other">
            <label for="other_allergy">Other</label>
        </div>


        <div class="form-group">
            <label for="preferences">Food Preferences:</label>
            <input type="checkbox" id="sweet" name="preferences[]" value="Sweet">
            <label for="pref_sweet">Sweet</label>
            <input type="checkbox" id="salty" name="preferences[]" value="Salty">
            <label for="pref_salty">Salty</label>
            <input type="checkbox" id="spicy" name="preferences[]" value="Spicy">
            <label for="pref_spicy">Spicy</label>
            <input type="checkbox" id="savory" name="preferences[]" value="Savory">
            <label for="pref_savory">Savory</label>
            <input type="checkbox" id="Other" name="preferences[]" value="Other">
            <label for="Other">Other</label><br>
        </div>
        <div class="form-group">
            <label for="favoriteFruit">What are your favorite fruits? (Select all that apply):</label><br>
            <input type="checkbox" id="apple" name="favorite_fruits[]" value="Apple">
            <label for="apple">Apple</label><br>
            <input type="checkbox" id="banana" name="favorite_fruits[]" value="Banana">
            <label for="banana">Banana</label><br>
            <input type="checkbox" id="orange" name="favorite_fruits[]" value="Orange">
            <label for="orange">Orange</label><br>
            <input type="checkbox" id="strawberry" name="favorite_fruits[]" value="Strawberry">
            <label for="strawberry">Strawberry</label><br>
            <input type="checkbox" id="grape" name="favorite_fruits[]" value="Grape">
            <label for="grape">Grape</label><br>
            <input type="checkbox" id="pineapple" name="favorite_fruits[]" value="Pineapple">
            <label for="pineapple">Pineapple</label><br>
            <input type="checkbox" id="watermelon" name="favorite_fruits[]" value="Watermelon">
            <label for="watermelon">Watermelon</label><br>
            <input type="checkbox" id="kiwi" name="favorite_fruits[]" value="Kiwi">
            <label for="kiwi">Kiwi</label><br>
            <input type="checkbox" id="mango" name="favorite_fruits[]" value="Mango">
            <label for="mango">Mango</label><br>
            <input type="checkbox" id="Other" name="favorite_fruits[]" value="Other">
            <label for="Other">Other</label><br>
        </div>
        <div class="form-group">
            <label for="favoriteVegetable">What are your favorite vegetables? (Select all that apply):</label><br>
            <input type="checkbox" id="carrot" name="favorite_vegetables[]" value="Carrot">
            <label for="carrot">Carrot</label><br>
            <input type="checkbox" id="broccoli" name="favorite_vegetables[]" value="Broccoli">
            <label for="broccoli">Broccoli</label><br>
            <input type="checkbox" id="spinach" name="favorite_vegetables[]" value="Spinach">
            <label for="spinach">Spinach</label><br>
            <input type="checkbox" id="tomato" name="favorite_vegetables[]" value="Tomato">
            <label for="tomato">Tomato</label><br>
            <input type="checkbox" id="bell_pepper" name="favorite_vegetables[]" value="Bell Pepper">
            <label for="bell_pepper">Bell Pepper</label><br>
            <input type="checkbox" id="cucumber" name="favorite_vegetables[]" value="Cucumber">
            <label for="cucumber">Cucumber</label><br>
            <input type="checkbox" id="zucchini" name="favorite_vegetables[]" value="Zucchini">
            <label for="zucchini">Zucchini</label><br>
            <input type="checkbox" id="lettuce" name="favorite_vegetables[]" value="Lettuce">
            <label for="lettuce">Lettuce</label><br>
            <input type="checkbox" id="onion" name="favorite_vegetables[]" value="Onion">
            <label for="onion">Onion</label><br>
            <input type="checkbox" id="Other" name="favorite_vegetables[]" value="Other">
            <label for="Other">Other</label><br>
        </div>
        <div class="form-group">
            <label for="favoriteMeat">What are your favorite types of meats? (Select all that apply):</label><br>
            <input type="checkbox" id="beef" name="favorite_meats[]" value="Beef">
            <label for="beef">Beef</label><br>
            <input type="checkbox" id="chicken" name="favorite_meats[]" value="Chicken">
            <label for="chicken">Chicken</label><br>
            <input type="checkbox" id="pork" name="favorite_meats[]" value="Pork">
            <label for="pork">Pork</label><br>
            <input type="checkbox" id="lamb" name="favorite_meats[]" value="Lamb">
            <label for="lamb">Lamb</label><br>
            <input type="checkbox" id="fish" name="favorite_meats[]" value="Fish">
            <label for="fish">Fish</label><br>
            <input type="checkbox" id="shrimp" name="favorite_meats[]" value="Shrimp">
            <label for="shrimp">Shrimp</label><br>
            <input type="checkbox" id="turkey" name="favorite_meats[]" value="Turkey">
            <label for="turkey">Turkey</label><br>
        </div>
        <div class="form-group">
            <label for="favoriteCuisine">What are your favorite types of ethnic cuisine? (Select all that apply):</label><br>
            <input type="checkbox" id="italian" name="favorite_cuisines[]" value="Italian">
            <label for="italian">Italian</label><br>
            <input type="checkbox" id="mexican" name="favorite_cuisines[]" value="Mexican">
            <label for="mexican">Mexican</label><br>
            <input type="checkbox" id="chinese" name="favorite_cuisines[]" value="Chinese">
            <label for="chinese">Chinese</label><br>
            <input type="checkbox" id="indian" name="favorite_cuisines[]" value="Indian">
            <label for="indian">Indian</label><br>
            <input type="checkbox" id="japanese" name="favorite_cuisines[]" value="Japanese">
            <label for="japanese">Japanese</label><br>
            <input type="checkbox" id="thai" name="favorite_cuisines[]" value="Thai">
            <label for="thai">Thai</label><br>
            <input type="checkbox" id="mediterranean" name="favorite_cuisines[]" value="Mediterranean">
            <label for="mediterranean">Mediterranean</label><br>
            <input type="checkbox" id="middle_eastern" name="favorite_cuisines[]" value="Middle Eastern">
            <label for="middle_eastern">Middle Eastern</label><br>
            <input type="checkbox" id="American" name="favorite_cuisines[]" value="American">
            <label for="American">American</label><br>
            <input type="checkbox" id="Other" name="favorite_cuisines[]" value="Other">
            <label for="Other">Other</label><br>
        </div>

        <div class="form-group">
            <input type="submit" value="Submit Preferences">
        </div>
    </form>
</div>

</body>
</html>