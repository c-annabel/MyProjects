#==========Weight & Height converter===========#
def weight_n_height_converter():
    global conv_type_input
    conv_type_input  = input(
        '''Please choose a valid converter from the list below: 
        1 (kg'->'oz)  / 2 (oz'->'kg)
        3 (kg'->'lbs) / 4 (lbs'->'kg)
        5 (cm'->'in)  / 6 (in'->'cm)
        7 (cm'->'ft)  / 8 (ft'->'cm)
        : ''')

def convertInputType(inputType):
    if inputType % 2 == 0:
        inputType -= 1
    else:
        inputType += 1
    return str(inputType)

conv_types = {"1":"kg", "2":"oz", "3":"kg", "4":"lbs", 
            "5":"cm", "6":"in", "7":"cm", "8":"ft"}

conv_type_input = ""
while conv_type_input not in conv_types:
    weight_n_height_converter()

weightHeight = float(input(f"Please enter your measurement in {conv_types[conv_type_input]}: "))

weightHeight_before = weightHeight
conv_type_input_before = conv_type_input

conv_kgoz_rate = 35.27396195
conv_kglb_rate = 2.20462262185
conv_cmin_rate = 2.54
conv_cmft_rate = 30.48

if conv_type_input == "1":
    weightHeight = "{:.2f}".format(weightHeight * conv_kgoz_rate)
elif conv_type_input == "2":
    weightHeight = "{:.2f}".format(weightHeight / conv_kgoz_rate)
elif conv_type_input == "3":
    weightHeight = "{:.2f}".format(weightHeight * conv_kglb_rate)
elif conv_type_input == "4":
    weightHeight = "{:.2f}".format(weightHeight / conv_kglb_rate)
elif conv_type_input == "5":
    weightHeight = "{:.2f}".format(weightHeight / conv_cmin_rate)
elif conv_type_input == "6":
    weightHeight = "{:.2f}".format(weightHeight * conv_cmin_rate)
elif conv_type_input == "7":
    weightHeight = "{:.2f}".format(weightHeight / conv_cmft_rate)
elif conv_type_input == "8":
    weightHeight = "{:.2f}".format(weightHeight * conv_cmft_rate)
else:
    weightHeight = 0

print(f"Result: {weightHeight_before} {conv_types[conv_type_input_before]} = {weightHeight} {conv_types[convertInputType(int(conv_type_input))]}. ")

